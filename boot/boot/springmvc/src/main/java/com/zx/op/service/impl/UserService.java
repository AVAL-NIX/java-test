package com.zx.op.service.impl;

import com.zx.framework.annotation.ZXAutowired;
import com.zx.op.service.IUserService;

/**
 * @author zhengxin
 * @date 2021/3/15
 */
public class UserService  {

    @ZXAutowired
    StudentService studentService;

    public String list(){
        System.out.println(" user list ");
        return " user list ";
    }


    public String add(){
        System.out.println(" user add ");
        studentService.add();
        return " user list ";
    }

}
