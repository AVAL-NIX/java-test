package SixBridge;

/**
 * 创建抽象接口 里面放桥接接口
 *
 * @author zx
 * @date 2019/6/25
 */
public abstract  class Shape {

    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    /**
     * 画图方法
     */
    public abstract void draw();
}
