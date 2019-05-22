package ThreeSingle;

/**
 * 枚举方式创建
 * 
 * @author avalon
 * @date 2019/5/22
 */
public class SingleFour {

    private SingleFour() {}

    public static SingleFour getInstance() {
        return SingleEnum.INSTANCE.getInstance();
    }










    public enum SingleEnum {
        INSTANCE;
        private SingleFour singleFour;

        private SingleEnum() {
            singleFour = new SingleFour();
        }

        public SingleFour getInstance() {
            return singleFour;
        }
    }
}
