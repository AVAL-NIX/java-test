package FourBuilder;

/**
 * 实体
 * @author avalon
 * @date 2019/5/22
 */
public class Burger extends BurgerWrapper {

    @Override
    public String name() {
        return " Burger Object ";
    }

    @Override
    public Packing packing() {
        return super.packing();
    }

    @Override
    public double price() {
        return 100.0f;
    }
}
