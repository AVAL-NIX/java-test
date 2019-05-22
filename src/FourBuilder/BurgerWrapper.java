package FourBuilder;

/**
 * 提供默认值
 * @author avalon
 * @date 2019/5/22
 */
public abstract class BurgerWrapper implements Item {


    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract double price();
}
