package com.boot.util;

/**
 * @author zhengxin
 * @date 2021/3/2
 */
public class Test {


    Clazzzaa clazzzaa  = new Clazzzaa("main");
    String str =new String("good");
    char[] ch = {'a', 'b', 'c'};

    Integer i = new Integer(10);
    int i2 = 10;
    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str, test.ch, test.i, test.clazzzaa, test.i2,test);
        System.out.println(test.str);
        System.out.println(test.ch );
        System.out.println(test.i);
        System.out.println(test.clazzzaa.toString());
        System.out.println(test.i2);
    }

    private void change(String str, char[] ch, Integer i, Clazzzaa clazzzaa, int i2, Test test) {
        str = " test ok ";
        ch[0] = 'g';
        i = 100;
        clazzzaa = new Clazzzaa("test class");
        i2 = 100;
        test.i2 = 100;
    }
}
