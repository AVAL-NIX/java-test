package ThreeSingle;

/**
 * 静态类
 *
 * @author avalon
 * @date 2019/5/22
 */
public class SingleThree {

    private static class SingleThreeInner {
        public static final SingleThree singleThree = new SingleThree();
    }

    private SingleThree() {
    }

    public static SingleThree getInstance() {
        return SingleThreeInner.singleThree;
    }

}
