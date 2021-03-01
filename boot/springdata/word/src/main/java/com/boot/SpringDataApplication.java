package com.boot;

import com.boot.model.Table;
import com.boot.model.TableCol;
import com.boot.service.BaseService;
import com.boot.util.Base64;
import com.boot.util.SpringUtil;
import com.boot.util.WordUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {


    public static void main(String[] args) {
//        SpringApplication.run(SpringDataApplication.class, args);
//        BaseService baseService = SpringUtil.getBean(BaseService.class);
//        List<Table> tables = baseService.findAllTables();
//        for (Table table : tables) {
//            List<TableCol> clos = baseService.findAllColumns(table.getTableName());
//            table.setCols(clos);
//        }
        try {
//            WordUtil.createDocContext("d:/test.doc",tables);
            WordUtil.createDocContext2("d:/test4.doc");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args)  {
//        String filename = "d://1231.jpg";
//        try {
//
//            BufferedImage image = readImage(filename);
//            int width = 100;
//            int height = 100;
//            BufferedImage bufferedImage = new BufferedImage(width, height, image.getType());
//            Graphics2D gr = bufferedImage.createGraphics();
//            //创建、透明背景
//            bufferedImage = gr.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
//            gr = bufferedImage.createGraphics();
//            //重绘
//            gr.drawImage(image.getScaledInstance(width, height, Image.SCALE_DEFAULT), 0, 0, width, height, null);
//            gr.dispose();
//            File file = new File("d://test5.jpg");
//            ImageIO.write(bufferedImage, "jpg", file);
//
//
//        } catch (Exception e) {
//
//        }
//    }

    public static BufferedImage get(BufferedImage image){
        int width = 100;
        int height = 100;
        BufferedImage img = new BufferedImage(width, height,image.getType());
        WritableRaster raster = img.getRaster();
        WritableRaster rasterJPEG = image.getRaster();

        for(int h=0; h<height; h++)
            for(int w=0; w<width; w++) {
                int[] p = new int[4];
                rasterJPEG.getPixel(w, h, p);
                p[0] = (int) (0.3 * p[0]);
                p[1] = (int) (0.59 * p[1]);
                p[2] = (int) (0.11 * p[2]);
                int y = p[0] + p[1] + p[2];
                raster.setSample(w,h,0,y);
            }
        return img;
    }

    /**
     * 图片、读取
     *
     * @param url
     * @return
     * @throws Exception
     */
    private static BufferedImage readImage(String url) throws Exception {
        File file = new File(url);
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis);
        return image;
    }


    public static void main2(String[] args)  {
        String urlString = Base64.encode("http://thirdqq.qlogo.cn/qqapp/1111345600/DF5A0971F3DF95E861AFF729E8B840B2/100".getBytes());
        String filename = "1231.jpg";
        String savePath = "D:\\";
        try {
            //用base64去解码
            byte[] decode = Base64.decode(urlString);
            String urls = new String(decode);
            // 构造URL
            URL url= new URL(urls);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5*1000);
            // 输入流
            InputStream is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf=new File(savePath);
            if(!sf.exists()){
                sf.mkdirs();
            }
            OutputStream os = new FileOutputStream(sf.getPath()+"/"+filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
            //System.out.println("下载完毕");

            //  PictureZoom pz = new PictureZoom();
            //    pz.getFace(savePath+"/"+filename, savePath+"/"+filename, "jpg", 100, 100);



        } catch (Exception e) {

        }
    }


}
