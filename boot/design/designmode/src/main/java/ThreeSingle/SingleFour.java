package ThreeSingle;

/**
 * 枚举方式创建
 * <p>
 * 根据类加载过程可以知道虚拟机会保证一个类的方法在多线程环境中被正确的加锁、同步
 * JVM会对方法加锁，其他线程都需要阻塞等待，
 * 直到活动线程执行方法完毕。需要注意的是，其他线程虽然会被阻塞，
 * 但如果执行方法的那条线程退出方法后，
 * 其他线程唤醒后不会再次进入方法。同一个类加载器下，一个类型只会初始化一次。
 *
 * @author avalon
 * @date 2019/5/22
 */
public class SingleFour {

    private SingleFour() {
    }

    public static SingleFour getInstance() {
        return SingleEnum.INSTANCE.getInstance();
    }


    public enum SingleEnum {
        INSTANCE;
        private SingleFour singleFour;

        private SingleEnum() {
            singleFour = new SingleFour();
        }

        public SingleFour getInstance() {
            return singleFour;
        }
    }
}
