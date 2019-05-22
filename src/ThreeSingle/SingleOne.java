package ThreeSingle;

/**
 * 饿汉模式
 *
 * @author avalon
 * @date 2019/5/22
 */
public class SingleOne {

    private SingleOne(){}

    private static SingleOne singleOne = new SingleOne();

    public static SingleOne getInstance(){
        return singleOne;
    }
}
