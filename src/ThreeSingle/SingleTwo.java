package ThreeSingle;

/**
 * 懒汉模式 ( 双重锁)
 * 
 * @author avalon
 * @date 2019/5/22
 */
public class SingleTwo {

    private SingleTwo() {}

    private static volatile SingleTwo singleTwo = null;

    public static SingleTwo getInstance() {
        if (singleTwo == null) {
            synchronized (SingleTwo.class) {
                if (singleTwo == null) {
                    singleTwo = new SingleTwo();
                }
            }
        }
        return singleTwo;
    }
}
