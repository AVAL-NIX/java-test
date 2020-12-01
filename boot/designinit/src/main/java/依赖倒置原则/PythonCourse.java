package 依赖倒置原则;

/**
 * @author zhengxin
 * @date 2020/11/27
 */
public class PythonCourse implements ICourse{

    @Override
    public void study() {
        System.out.println(" study python");
    }
}
