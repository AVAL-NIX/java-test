package 测试静态块;

/**
 * @author zhengxin
 * @date 2020/12/24
 */
public class Person {

    public TestObj a = new TestObj("person testobj 非静态");
    public static final TestObj b = new TestObj("person testobj  静态");

    static {
        System.out.println("Person static");
    }

    public Person() {
        System.out.println("Person构造");
    }
}
