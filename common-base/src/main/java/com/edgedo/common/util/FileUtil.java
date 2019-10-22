package com.edgedo.common.util;


import org.apache.commons.io.IOUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by wangzhen
 */
public class FileUtil {


    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    //定义文件保存路径的系统配置常量
    public static final String tdp_upfile_img_save_forder_key = "tdp_upfile_img_save_forder";
    //图片的域名的系统配置常量
    public static final String tdp_img_host_key = "tdp_img_host_key";

    public static final String photoNameExt = "jpg,gif,png,jpeg";


    //头像文件的文件路径
    public static final String USER_FACE_PHOTO_MODEL_PATH = "upfile" + File.separator + "userface" ;
    //学习时候的人脸文件路径
    public static final String LEARN_FACE_PHOTO_MODEL_PATH = "upfile" + File.separator + "learnface" ;
    //学习答题时候的人脸文件路径
    public static final String ANSWER_FACE_PHOTO_MODEL_PATH = "upfile" + File.separator + "answerface" ;
    public static final String LEARN_LIVE_PHOTO_MODEL_PATH = "upfile" + File.separator + "livelearnpic" ;
    public static final String YW_TRAINLESSION_COVERIMG_PATH = "upfile" + File.separator + "coverimg";


    /**
     *  保存文件
     */
    public static String saveFile(MultipartFile file, String fileForder, boolean webPathFlag) throws Exception {
        String uuid = Guid.guid();
        String oraName = file.getOriginalFilename();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = file.getInputStream();
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }

    public static String saveFile(byte[] fileByte,String fileForder,boolean webPathFlag,String fileExt) throws Exception {
        String uuid = Guid.guid();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new ByteArrayInputStream(fileByte);
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }

    /**
     *  保存文件
     */
    public static String saveFile(File file,String fileForder,boolean webPathFlag) throws Exception {
        String uuid = Guid.guid();
        String oraName = file.getName();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(file);
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }

    /**
     *  保存文件
     */
    public static String saveFile(byte[] fileArr,String fileForder,String oraName,boolean webPathFlag) throws Exception {
        String uuid = Guid.guid();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        Calendar cal = Calendar.getInstance();
        String year = cal.get(Calendar.YEAR) +"";
        String month = cal.get(Calendar.MONTH) +"";
        String day = cal.get(Calendar.DAY_OF_MONTH) +"";
        String relativePath = year + File.separator + month
                + File.separator + day;
        String fileName = fileForder + File.separator + relativePath + File.separator + uuid + "." + fileExt;

        File targetFile = new File(fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new ByteArrayInputStream(fileArr);
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        if(webPathFlag==true){
            return changeFilePathToWebPath(relativePath) + "/" + uuid + "." + fileExt;
        }else{
            return relativePath + File.separator + uuid + "." + fileExt;
        }

    }


    /**
     *  保存文件
     */
    public static void saveCopyFile(MultipartFile file, String realPath) throws Exception {
        String oraName = file.getOriginalFilename();

        File targetFile = new File(realPath);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        InputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = file.getInputStream();
            fos = new FileOutputStream(targetFile);
            IOUtils.copyLarge(fis, fos);
        }catch(Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
    }

    /**
     * 是否是图片
     * @return
     */
    public static boolean isImage(MultipartFile file){
        String extend = getFileExtend(file);
        if(photoNameExt.indexOf(extend)>=0){
            return true;
        }else{
            return false;
        }

    }


    public static String getFileExtend(MultipartFile file){
        String oraName = file.getOriginalFilename();
        String fileExt = oraName.substring(oraName.lastIndexOf(".")+1).toLowerCase();
        return fileExt;
    }

    public static String getFileExtend(String filePath){
        String fileExt = filePath.substring(filePath.lastIndexOf(".")+1).toLowerCase();
        return fileExt;
    }

    /**
     *  获得图片宽度
     * @param photo
     * @return
     * @throws Exception
     */
    public static int getPhotoWidth(MultipartFile photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = photo.getInputStream();
            sourceImg = ImageIO.read(is);
            return sourceImg.getWidth();
        } catch (IOException e) {
           throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getPhotoWidth(File photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = new FileInputStream(photo);
            sourceImg = ImageIO.read(is);
            return sourceImg.getWidth();
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *  获得图片高度
     * @param photo 图片
     * @return
     * @throws Exception
     */
    public static int getPhotoHeight(MultipartFile photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = photo.getInputStream();
            sourceImg = ImageIO.read(is);
            return sourceImg.getHeight();
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getPhotoHeight(File photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = new FileInputStream(photo);
            sourceImg = ImageIO.read(is);
            return sourceImg.getHeight();
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  获得图片宽度高度比
     * @param photo 图片
     * @return
     * @throws Exception
     */
    public static double getPhotoWidthDeiveHeight(MultipartFile photo) throws Exception {
        BufferedImage sourceImg = null;
        InputStream is = null;
        try {
            is = photo.getInputStream();
            sourceImg = ImageIO.read(is);
            int width = sourceImg.getWidth();
            int height = sourceImg.getHeight();
            return width*1.0/(height*1.0);
        } catch (IOException e) {
            throw new Exception("文件读取错误");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     */
    public static void deleteFile(final String path){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try{
                    String rootpath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
                    String filePath = rootpath + File.separator + path.replace("/", File.separator);
                    String fileForder = filePath.substring(0,filePath.lastIndexOf(File.separator));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
                    File forder = new File(fileForder);
                    File file = new File( forder,fileName);
                    if(file.exists()){
                        file.delete();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }

    /**
     * 根据绝对路径删除文件
     * @param filePath
     */
    public static void deleteFileByRealPath(final String filePath){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try{
                    File file = new File(filePath);
                    if(file.exists()){
                        file.delete();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }

    /**
     * 将web路径转换成文件路径
     * @param path
     * @return
     */
    public static String changeWebPathToFilePath(String path){
        String filePath = "";
        String[] strArr = path.split("/");
        for(int i=0;i<strArr.length;i++){
            if(i==strArr.length-1){
                filePath = filePath+strArr[i];
            }else{
                filePath = filePath+strArr[i]+File.separator;
            }

        }
        return filePath;
    }

  /*  public static void main(String[] args){
//        String str = "/upfile/userface//2018/6/16/9a3531e4131e4437b933ead89a243c49.jpg";
//        System.out.println(changeWebPathToFilePath(str));
        String base64 = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgKCgkICQkKDA8MCgsOCwkJDRENDg8QEBEQCgwSExIQEw8QEBD/2wBDAQMDAwQDBAgEBAgQCwkLEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBD/wAARCAABAAEDASIAAhEBAxEB/8QAFQABAQAAAAAAAAAAAAAAAAAAAAn/xAAUEAEAAAAAAAAAAAAAAAAAAAAA/8QAFQEBAQAAAAAAAAAAAAAAAAAAAAL/xAAUEQEAAAAAAAAAAAAAAAAAAAAA/9oADAMBAAIRAxEAPwCjAAt//9k=";
        generateImageFromBase64Str(base64,"D:\\1.jpg");
    }*/

    /**
     * 将文件路径转换成web路径
     * @param filepath
     * @return
     */
    public static String changeFilePathToWebPath(String filepath){
        String webpath = filepath.replaceAll("\\\\","\\/");

        return webpath;
    }

    /**
     * 获取图片的base64编码
     * @param tdp_upfile_forder
     * @param webPath
     */
    public static String getImgFileBase64String(String tdp_upfile_forder, String webPath) {
        String filePath =  changeWebPathToFilePath(webPath);
        String targetFile = tdp_upfile_forder + filePath;
        System.out.println("转图片的路径;" + targetFile);
        File file = new File(targetFile);
        if(file.exists()){
            return getImageBase64Str(file);
        }else{
            return "";
        }

    }

    /**
     * 图片转化成base64字符串
     * @param target
     * @return
     */
    public static String getImageBase64Str(File target){
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(target);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    /**
     * 图片转化成base64字符串
     * @param buffer 图片字节数组
     * @return
     */
    public static String getImageBase64Str(byte[] buffer){
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(buffer);//返回Base64编码过的字节数组字符串
    }

    /**
     *   base64字符串转化成图片保存到本地
     */
    public static boolean generateImageFromBase64Str(String base64Str,String targetFileName)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try{
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64Str);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            File targetFile = new File(targetFileName);
            File forder = targetFile.getParentFile();
            if(!forder.exists()){
                forder.mkdirs();
            }
            if(!targetFile.exists()){
                forder.createNewFile();
            }
            //生成jpeg图片
            out = new FileOutputStream(targetFile);
            out.write(b);
            out.flush();

            return true;
        }catch (Exception e) {
            return false;
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *   base64字符串转化成图片保存到本地
     */
    public static byte[] generateImageFromBase64Str(String base64Str)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) //图像数据为空
            return new byte[0];
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try{
            //Base64解码
            byte[] b = null;
            if (base64Str.indexOf("data:image/jpeg;base64,") != -1) {
                b = decoder.decodeBuffer(base64Str.replaceAll("data:image/jpeg;base64,", ""));
            } else {
                if (base64Str.indexOf("data:image/png;base64,") != -1) {
                    b = decoder.decodeBuffer(base64Str.replaceAll("data:image/png;base64,", ""));
                } else {
                    b = decoder.decodeBuffer(base64Str.replaceAll("data:image/jpg;base64,", ""));
                }
            }
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
           return b;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }

    public static String getImageSuffix(String imgBase64Str){
        String suffix = ".jpg";
        if(imgBase64Str!=null){
            if(imgBase64Str.indexOf("data:image/jpeg;base64,") != -1 ){
                suffix = ".jpeg";
            }
            if (imgBase64Str.indexOf("data:image/png;base64,") != -1) {
                suffix = ".png";
            }
            if (imgBase64Str.indexOf("data:image/jpg;base64,") != -1) {
                suffix = ".jpg";
            }
        }
        return suffix;
    }




    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 将文件读取成字节数组
     * @param file
     * @return
     */
    public static byte[] getFileByteArr(File file) throws  Exception {
        InputStream is = new FileInputStream(file);
        int length = is.available();
        byte[] byteArr = new byte[length];
        is.read(byteArr);
        return byteArr;
    }


}
