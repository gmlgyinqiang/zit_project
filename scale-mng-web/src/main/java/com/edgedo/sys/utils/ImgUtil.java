
package com.edgedo.sys.utils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import javax.imageio.ImageIO;


import com.edgedo.common.util.FileUtil;

import sun.misc.BASE64Encoder;


public class ImgUtil {
    private Graphics2D g        = null;
    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
//        exportImg2("万魔声学","E:\\imge\\small.jpg");
//            changeSize("d:\\b.png", "d:\\d.png", 640, 640, false);
            // 合并a.png+d.png->c.png
//            mergeImage("E:\\imge\\big.jpg", "E:\\imge\\small.png", "E:\\imge\\d.png");
//        }


        // 图片路径
        String bigImageURL = "https://scale.oss-cn-beijing.aliyuncs.com/htimg/20190906/4a68ea3dc9314573ad2fd456facda675.jpeg";
        String smallImageURL = "https://scale.oss-cn-beijing.aliyuncs.com/htimg/20190906/ab8d10ab07c34fec857433c88cf19b45.jpeg";

        BufferedImage bigImageURL1 = getRemoteBufferedImage(bigImageURL);
        BufferedImage smallImageURL1 = getRemoteBufferedImage(smallImageURL);

        String s = mergeImage1(bigImageURL1, smallImageURL1);


//        BufferedImage image = getRemoteBufferedImage(imageURL);
//        if (smallImageURL1 != null) {
//            System.out.println("BufferedImage的高度: " + smallImageURL1.getHeight());
//            System.out.println("BufferedImage的宽度: " + smallImageURL1.getWidth());
//        } else {
//            System.out.println("BufferedImage图片不存在!");
////        }
//        }
    }


//    public static void exportImg1(){
//        int width = 100;
//        int height = 100;
//        String s = "你好";
//
//        File file = new File("E:\\imge\\big.jpg");
//
//        Font font = new Font("Serif", Font.BOLD, 10);
//        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2 = (Graphics2D)bi.getGraphics();
//        g2.setBackground(Color.WHITE);
//        g2.clearRect(0, 0, width, height);
//        g2.setPaint(Color.RED);
//
//        FontRenderContext context = g2.getFontRenderContext();
//        Rectangle2D bounds = font.getStringBounds(s, context);
//        double x = (width - bounds.getWidth()) / 2;
//        double y = (height - bounds.getHeight()) / 2;
//        double ascent = -bounds.getY();
//        double baseY = y + ascent;
//
//        g2.drawString(s, (int)x, (int)baseY);
//
//        try {
//            ImageIO.write(bi, "jpg", file);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public static void exportImg2(String username,String headImg){
//        try {
//            //1.jpg是你的 主图片的路径
//            InputStream is = new FileInputStream("E:\\imge\\big.jpg");
//
//
//            //通过JPEG图象流创建JPEG数据流解码器
//            JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
//            //解码当前JPEG数据流，返回BufferedImage对象
//            BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
//            //得到画笔对象
//            Graphics g = buffImg.getGraphics();
//
//            //创建你要附加的图象。
//            //小图片的路径
//            ImageIcon imgIcon = new ImageIcon(headImg);
//
//            //得到Image对象。
//            Image img = imgIcon.getImage();
//
//            //将小图片绘到大图片上。
//            //5,300 .表示你的小图片在大图片上的位置。
//            g.drawImage(img,400,15,null);
//
//            //设置颜色。
//            g.setColor(Color.BLACK);
//
//
//            //最后一个参数用来设置字体的大小
//            Font f = new Font("宋体",Font.PLAIN,25);
//            Color mycolor = Color.red;//new Color(0, 0, 255);
//            g.setColor(mycolor);
//            g.setFont(f);
//
//            //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
//            g.drawString(username,100,135);
//
//            g.dispose();
//
//
//            OutputStream os;
//
//            //os = new FileOutputStream("d:/union.jpg");
//            String shareFileName = "E:\\imge\\" + System.currentTimeMillis() + ".jpg";
//            os = new FileOutputStream(shareFileName);
//            //创键编码器，用于编码内存中的图象数据。
//            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
//            en.encode(buffImg);
//
//            is.close();
//            os.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ImageFormatException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }


    public static void mergeImage(String backImage, String srcImage, String descImage) {
        System.out.println(backImage);
        System.out.println(srcImage);
        System.out.println(descImage);
        try {
            int offset = 0;
            BufferedImage backBufferedImage = ImageIO.read(new File(backImage));
            BufferedImage srcBufferedImage = ImageIO.read(new File(srcImage));
            // 输出图片宽度
            int width = backBufferedImage.getWidth() + offset;
            // 输出图片高度
            int height = backBufferedImage.getHeight() + offset;
            BufferedImage descBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D graphics2d = (Graphics2D) descBufferedImage.getGraphics();
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // 往画布上添加图片,并设置边距
            graphics2d.drawImage(backBufferedImage, null, 0, 0);
            graphics2d.drawImage(srcBufferedImage, null, 20, 20);
            graphics2d.dispose();
            // 输出新图片
            ImageIO.write(descBufferedImage, "png", new File(descImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  String  mergeImage1(BufferedImage backBufferedImage, BufferedImage srcBufferedImage) {
//        System.out.println(backImage);
//        System.out.println(srcImage);
//        System.out.println(descImage);/
        try {
            int offset = 0;
//            BufferedImage backBufferedImage = ImageIO.read(new File(backImage));
//            BufferedImage srcBufferedImage = ImageIO.read(new File(srcImage));
            // 输出图片宽度
            int width = backBufferedImage.getWidth() + offset;
            // 输出图片高度
            int height = backBufferedImage.getHeight() + offset;
            BufferedImage descBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D graphics2d = (Graphics2D) descBufferedImage.getGraphics();
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // 往画布上添加图片,并设置边距
            graphics2d.drawImage(backBufferedImage, null, 0, 0);
            graphics2d.drawImage(srcBufferedImage, 1650, 1830, 230,175,null);
            graphics2d.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
            ImageIO.write(descBufferedImage, "png", baos);//写入流中
            byte[] bytes = baos.toByteArray();//转换成字节
            BASE64Encoder encoder = new BASE64Encoder();
            String png_base64 =  encoder.encodeBuffer(bytes).trim();//转换成base64串
            png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
            return png_base64;

            // 输出新图片
//            ImageIO.write(descBufferedImage, "png", new File(descImage));
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }


    public static  String  mergeImage2(BufferedImage backBufferedImage, BufferedImage srcBufferedImage) {
//        System.out.println(backImage);
//        System.out.println(srcImage);
//        System.out.println(descImage);/
        try {
            int offset = 0;
//            BufferedImage backBufferedImage = ImageIO.read(new File(backImage));
//            BufferedImage srcBufferedImage = ImageIO.read(new File(srcImage));
            // 输出图片宽度
            int width = backBufferedImage.getWidth() + offset;
            // 输出图片高度
            int height = backBufferedImage.getHeight() + offset;
            BufferedImage descBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D graphics2d = (Graphics2D) descBufferedImage.getGraphics();
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // 往画布上添加图片,并设置边距
            graphics2d.drawImage(backBufferedImage, null, 0, 0);
            graphics2d.drawImage(srcBufferedImage, 1650, 1830, 230,175,null);
            graphics2d.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
            ImageIO.write(descBufferedImage, "png", baos);//写入流中
            byte[] bytes = baos.toByteArray();//转换成字节
            BASE64Encoder encoder = new BASE64Encoder();
            String png_base64 =  encoder.encodeBuffer(bytes).trim();//转换成base64串
            png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
            return png_base64;

            // 输出新图片
//            ImageIO.write(descBufferedImage, "png", new File(descImage));
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    /**
     * 获取远程网络图片信息
     * @param imageURL
     * @return
     */
    public static BufferedImage getRemoteBufferedImage(String imageURL) {
        URL url = null;
        InputStream is = null;
        BufferedImage bufferedImage = null;
        try {
            url = new URL(imageURL);
            is = url.openStream();
            bufferedImage = ImageIO.read(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("imageURL: " + imageURL + ",无效!");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("imageURL: " + imageURL + ",读取失败!");
            return null;
        } finally {
            try {
                if(is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("imageURL: " + imageURL + ",流关闭异常!");
                return null;
            }
        }
        return bufferedImage;
    }


}