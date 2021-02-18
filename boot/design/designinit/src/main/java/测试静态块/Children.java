package 测试静态块;

/**
 * @author zhengxin
 * @date 2020/12/24
 */
public class Children extends Person {
    static {
        System.out.println("Children static");
    }

    public TestObj a = new TestObj("Children testobj 非静态");
    public static final TestObj b = new TestObj("Children testobj  静态");

    public Children() {
        System.out.println("Children 构造");
    }
}
