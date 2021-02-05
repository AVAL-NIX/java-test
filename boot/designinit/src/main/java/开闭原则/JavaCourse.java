package 开闭原则;

import lombok.Data;

/**
 * @author zhengxin
 * @date 2020/11/27
 */
@Data
public class JavaCourse extends ICourse {
    private int id;
    private String name;
    private double price;

    public JavaCourse(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
