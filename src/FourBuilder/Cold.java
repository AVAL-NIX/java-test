package FourBuilder;

/**
 * 实体类
 * @author avalon
 * @date 2019/5/22
 */
public class Cold extends ColdBottle {

    @Override
    public Packing packing() {
        return super.packing();
    }

    @Override
    public double price() {
        return 200f;
    }

    @Override
    public String name() {
        return " Cold Object";
    }
}
