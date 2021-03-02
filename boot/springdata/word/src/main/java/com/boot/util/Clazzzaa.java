package com.boot.util;

/**
 * @author zhengxin
 * @date 2021/3/1
 */
public class Clazzzaa {


    String name ;

    public Clazzzaa(String name) {
        this.name = name;
    }

    public String hello(){
        return "hello";
    }


    @Override
    public String toString() {
        return "Clazzzaa{" +
                "name='" + name + '\'' +
                '}';
    }
}
