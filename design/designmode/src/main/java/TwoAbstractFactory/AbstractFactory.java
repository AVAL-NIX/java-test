package TwoAbstractFactory;

import OneFactory.shape;

/**
 * @author avalon
 * @date 2019/5/22
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract shape getSharp(String sharp);
}
