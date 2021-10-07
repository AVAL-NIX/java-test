package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bctrl {

    @Autowired
    Actrl actrl;


    public void test(){
        actrl.test();
    }

}
