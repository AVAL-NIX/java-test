package com.zx.controller;

import com.zx.annation.Autowired;
import com.zx.annation.Controller;
import com.zx.annation.RequestMapping;
import com.zx.annation.RequestParam;
import com.zx.service.HelloService;
import com.zx.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengxin
 * @date 2021/2/20
 */
@RequestMapping("/student")
@Controller
public class StudentController {

        @Autowired
        StudentService studentService;

        @RequestMapping("/index")
        public String index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                            @RequestParam("test") String str) throws IOException {
            httpServletResponse.getWriter().write("str : " + str + ", service : " + studentService.getStudentName());
            return str;
        }


}
