package EightDecorator.impl;

import EightDecorator.Shape;

/**
 * 装饰具体实现
 */
public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}