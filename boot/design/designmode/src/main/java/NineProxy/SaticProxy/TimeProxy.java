package NineProxy.SaticProxy;

public class TimeProxy {

    public MoiveAble moiveAble;

    public TimeProxy(MoiveAble moiveAble) {
        this.moiveAble = moiveAble;
    }

    public void moive() {

        long btime = System.currentTimeMillis();

        System.out.println(" 汽车开始行驶 !");
        moiveAble.moive();

        long etime = System.currentTimeMillis();

        System.out.println("用时 : " + (etime - btime));

    }
}