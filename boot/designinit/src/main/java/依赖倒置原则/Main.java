package 依赖倒置原则;

/**
 * @author zhengxin
 * @date 2020/11/27
 */
public class Main {

    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.study(new JavaCourse());
        tom.study(new PythonCourse());


    }
}
