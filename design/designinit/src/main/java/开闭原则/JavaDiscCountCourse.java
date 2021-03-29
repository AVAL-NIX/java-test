package 开闭原则;

import lombok.Data;

/**
 * @author zhengxin
 * @date 2020/11/27
 */
public class JavaDiscCountCourse extends JavaCourse {

    public JavaDiscCountCourse(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.65;
    }
}
