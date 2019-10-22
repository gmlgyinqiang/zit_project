package com.edgedo.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.edgedo.common.base.annotation.Pass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 *
 * @date 2019/9/20 11:49
 */
@Controller
@RequestMapping("views/com/edgedo/sys/article")
public class UEditorController {

    public static String ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";
    public static String ACCESSKEYID = "LTAIRbNHjcnqJBhc";
    public static String ACCESSKEYSECRET = "8gITtt4WOqweBkcaHjIxEJm1nwwyuT";
    public static String BUCKETNAME = "scale";
    public static String KEY = "images/";



    @RequestMapping("/look")
    public String look(){
        return "/ueditor/index";
    }

    @Pass
    @RequestMapping("/config")
    public String config(String action, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("调用config");
        System.out.println("加载配置文件config");
        return "redirect:/views/com/edgedo/sys/article/jsp/config.json";
    }










    public class JsonResult<T> {
        public Boolean result;
        public String data;
        public String msg;

        public JsonResult(boolean result, String msg, String data) {
            this.result=result;
            this.msg=msg;
            this.data=data;
        }
    }

    /**
     * @param request
     * @MethodName myphotoupload
     * @Description 图片上传
     * @Auther SongYapeng
     * @Date 2019/1/15 9:16
     * @Since JDK 1.8
     */
    @ResponseBody
    @RequestMapping(value = "/photoupload")
    public String myphotoupload(HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        String key = "";
        String fileNames = "";
        ret.put("success", false);
        ret.put("msg", "请求失败[PU01]");
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
               MultipartFile file = req.getFile(iterator.next());
                fileNames = file.getOriginalFilename();
                InputStream input = file.getInputStream();

                // 创建OSSClient实例
                OSSClient ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);
                // 上传文件流
                ossClient.putObject(BUCKETNAME, KEY + fileNames, input);
                ossClient.shutdown();
            }
            ret.put("success", true);
            ret.put("msg", key + fileNames);
           // System.out.println(("图片上传阿里云 name=" + key + fileNames));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret.getString("msg");
    }

    /**
     * 文件上传
     * @param file
     */
    @RequestMapping(value = "uploadBlog",method = RequestMethod.POST)
    public String uploadBlog(MultipartFile file){
        try {
            if(null != file){
                String filename = file.getOriginalFilename();
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    String uploadUrl = AliyunOSSUtil.upload(newFile);

                }

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "toUploadBlog",method = RequestMethod.GET)
    public String toUploadBlog(){
        return "upload";
    }










}
