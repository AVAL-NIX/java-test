package com.zx.controller;

import com.zx.annation.Autowired;
import com.zx.annation.Controller;
import com.zx.annation.RequestMapping;
import com.zx.annation.RequestParam;
import com.zx.service.HelloService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/hello")
@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                        @RequestParam("test") String str) throws IOException {
        httpServletResponse.getWriter().write("str : " + str + ", service : " + helloService.hello());
        return str;
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                      @RequestParam("a") double a, @RequestParam("b") double b) throws IOException {
        httpServletResponse.getWriter().write(" a+b : " + (a + b) + ", service : " + helloService.hello());
        return "";
    }
}
