package com.zx.service;

import com.zx.annation.Autowired;
import com.zx.annation.Service;

@Service
public class StudentService {

    @Autowired
    HelloService helloService;

    public String getStudentName() {
        return "this is zheng xin " + helloService.getName();
    }
}
