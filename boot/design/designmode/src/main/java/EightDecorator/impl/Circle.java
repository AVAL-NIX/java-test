package EightDecorator.impl;

import EightDecorator.Shape;

/**
 * 装饰具体实现
 *
 * @author zx
 * @date 2019/6/25
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}