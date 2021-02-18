package 测试静态块;

/**
 * @author zhengxin
 * @date 2020/12/24
 */
public class TestObj {

    public TestObj(String name) {
        System.out.println("  test obj 实例了" + name);
    }


    public static void main(String[] args) {
        Person children = new Children();
    }
}
