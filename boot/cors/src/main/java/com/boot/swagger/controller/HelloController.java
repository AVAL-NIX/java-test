package com.boot.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hell(){
        return "hello world";
    }


    @GetMapping("down")
    public void down(HttpServletResponse response)throws Exception{
        response.setHeader("Access-Control-Allow-Origin", "*"); // 解决请求头跨域问题
        response.setContentType("application/pdf");
        File f1 = new File("C:\\Users\\zhengxin\\Pictures\\111.pdf");
        FileInputStream reader= new FileInputStream(f1);
        BufferedInputStream BufferReader = new BufferedInputStream(reader);
        // 创建servlet 输出流对象
        ServletOutputStream sos = response.getOutputStream();
        int b;
        while ((b = BufferReader.read())!= -1){
            sos.write(b);
        }
        sos.close();
        reader.close();
    }
}
