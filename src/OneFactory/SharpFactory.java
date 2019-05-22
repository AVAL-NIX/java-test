package OneFactory;

/**
 * @author avalon
 * @date 2019/5/22
 */
public class SharpFactory {

    /**
     * 使用 getShape 方法获取形状类型的对象
     * 
     * @param shapeType
     * @return
     */
    public static shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
