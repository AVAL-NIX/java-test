package com.boot.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.boot.config.EasyExcelUtil;
import com.boot.config.ModelA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DrawController {

    @RequestMapping("/")
    public ModelAndView drawPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<String> result = new ArrayList<>();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        List<String> result = new ArrayList<>();
        modelAndView.setViewName("add");
        return modelAndView;
    }

    public static Set<String> result = new HashSet<>();;

    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            InputStream in = file.getInputStream();
            InputStream inputStream = new BufferedInputStream(in);
            //读入文件，每一行对应一个 Model，获取 Model 列表
            List<List<String>> objectList = EasyExcelUtil.readExcelWithModel(inputStream, ExcelTypeEnum.XLSX);
            result.clear();
            for (List<String> strings : objectList) {
                for (String string : strings) {
                    result.add(string);
                }
            }
            System.out.println("ob" + result.toString());
            modelAndView.setViewName("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Set<String> getList(){
        return result;
    }


    @RequestMapping("/set")
    @ResponseBody
    public void response(String data){
        System.out.println(data);
    }

}
