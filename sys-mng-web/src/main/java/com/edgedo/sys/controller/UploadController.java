package com.edgedo.sys.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.edgedo.common.base.annotation.Pass;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/views/ueditor")
public class UploadController {

    public static String endpoint = "oss-cn-beijing.aliyuncs.com";
    public static String accessKeyId = "LTAIuqiMJLCCRRdH";
    public static String accessKeySecret = "ComhSAx9liiYNW69brUVi2eq3u7SNX";
    public static String bucketName = "scale";
    private Object JsonResult;

    /**
     * 上传方法
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public JsonResult fileUpload(MultipartFile file) {
        String imageurl = "";
        String imagename = "";
        try {
           if(file!=null){
               //获得上传图片的名称
               String fileName = file.getOriginalFilename();
               //获得图片的后缀
               String [] split=fileName.split("\\.");
               if (split.length>0){
                   //后缀
                   String  imagesuffix=split[1];
                   imagename = "images/" + UUID.randomUUID() +"."+imagesuffix;
               }else{
                   //默认jpg
                   imagename = "images/" + UUID.randomUUID() +".jpg";
               }
               imageurl = uploadFile(imagename, file);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error");
            return new JsonResult(false, "上传失败", imageurl);
        }
        return new JsonResult(true, "上传成功", imageurl);
    }

    /**
     * 上传音频
     * @param file
     * @return
     */
    @Pass
    @PostMapping("/uploadVideo")
    public JsonResult uploadVideo(MultipartFile file) {
        String url = "";
        String imagename = "";
        try {
            if(file!=null){
                //获得文件名
                String originalFilename=file.getOriginalFilename();
                System.out.println("上传文件的名称"+originalFilename);
                String [] filename=originalFilename.split("\\.");
                if(filename.length>0){
                    //获得后缀
                    String namesuffix=filename[1];
                    imagename = "video/" + UUID.randomUUID() + "."+namesuffix;
                }else{
                    //默认mp3
                    imagename = "video/" + UUID.randomUUID() + ".mp3";
                }
                url = uploadVideo(imagename, file);
                System.out.println("videourl"+url);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error");
            return new JsonResult(false, "上传失败", url);
        }
        return new JsonResult(true, "上传成功", url);
    }



    public class JsonResult {
        public boolean result;
        public String data;
        public String msg;

        public JsonResult(boolean result, String msg, String data) {
            this.result = result;
            this.msg = msg;
            this.data = data;
        }
    }


    /**
     * 功能描述: 上传图片
     *
     * @param:[objectKey, multipartFile 文件的新名称]
     * @return:java.lang.String
     **/
    public static String uploadFile(String objectKey, MultipartFile multipartFile)
            throws OSSException, ClientException, FileNotFoundException {

        // 创建OSSClient的实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        StringBuffer sb = new StringBuffer();
        // 上传的文件不是空，并且文件的名字不是空字符串
        if (multipartFile.getSize() != 0 && !"".equals(multipartFile.getName())) {
            ObjectMetadata om = new ObjectMetadata();
            om.setContentLength(multipartFile.getSize());
            // 设置文件上传到服务器的名称
            om.addUserMetadata("filename", objectKey);
            try {
                ossClient.putObject(bucketName, objectKey, new ByteArrayInputStream(multipartFile.getBytes()), om);
            } catch (IOException e) {

            }
        }
        // 设置这个文件地址的有效时间
        String images = "/images";
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl(bucketName, images, new Date()).toString();
        String imgurl = "https://" + bucketName + "." + endpoint + "/" + objectKey;
        return imgurl;
    }

    /**
     * 功能描述: 上传视频
     *
     * @param:[objectKey, multipartFile 文件的新名称]
     * @return:java.lang.String
     **/
    public static String uploadVideo(String objectKey, MultipartFile multipartFile)
            throws OSSException, ClientException, FileNotFoundException {
        // 创建OSSClient的实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        StringBuffer sb = new StringBuffer();
        // 上传的文件不是空，并且文件的名字不是空字符串
        if (multipartFile.getSize() != 0 && !"".equals(multipartFile.getName())) {
            ObjectMetadata om = new ObjectMetadata();
            om.setContentLength(multipartFile.getSize());
            // 设置文件上传到服务器的名称
            om.addUserMetadata("filename", objectKey);
            try {
                ossClient.putObject(bucketName, objectKey, new ByteArrayInputStream(multipartFile.getBytes()), om);
            } catch (IOException e) {

            }
        }
        // 设置这个文件地址的有效时间
        String images = "/video";
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl(bucketName, images, new Date()).toString();
        String imgurl = "https://" + bucketName + "." + endpoint + "/" + objectKey;
        return imgurl;
    }




}
