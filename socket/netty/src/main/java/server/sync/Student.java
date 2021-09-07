package server.sync;

/**
 * @author zhengxin
 * @date 2021/9/6
 */
public class Student {


    public static synchronized void A(){
        try {
            System.out.println(" AAAAAAAAAAAAAAAAAAA ");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void B(){
        try {
            System.out.println(" BBBBBBBBBBBBBBBBBB");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
