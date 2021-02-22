package com.zx.service;

import com.zx.annation.Autowired;
import com.zx.annation.Service;

@Service
public class HelloService {

    @Autowired
    StudentService studentService;

    public String hello() {
        return "hello service : " + studentService.getStudentName();
    }

    public String getName() {
        return "hello name : zhengxin ";
    }
}
