package OneFactory;

import javafx.scene.shape.Circle;

/**
 * 工厂模式
 *
 * @author avalon
 * @date 2019/5/22
 */
public class OneMain {


    public static void main(String[] args) {
        shape s = SharpFactory.getShape("CIRCLE");
        s.draw();
        Circle circle =new Circle();
    }
}
