package FourBuilder;

/**
 * 给默认值
 * @author avalon
 * @date 2019/5/22
 */
public abstract class ColdBottle implements Item {



    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract double price();
}
