package TwoAbstractFactory;

import OneFactory.shape;

/**
 * @author avalon
 * @date 2019/5/22
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("YELLOW")) {
            return new Yellow();
        }
        return null;
    }

    @Override
    public shape getSharp(String sharp) {
        return null;
    }
}
