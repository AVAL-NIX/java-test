package TwoAbstractFactory;

import OneFactory.Circle;
import OneFactory.Rectangle;
import OneFactory.shape;
import OneFactory.Square;

/**
 * @author avalon
 * @date 2019/5/22
 */
public class SharpFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public shape getSharp(String sharp) {
        if (sharp == null) {
            return null;
        }
        if (sharp.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (sharp.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (sharp.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
