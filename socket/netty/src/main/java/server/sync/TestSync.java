package server.sync;

/**
 * @author zhengxin
 * @date 2021/9/6
 */
public class TestSync {

    public static  boolean flag = false;
    public static void main(String[] args) {
        new Thread(()-> {
            System.out.println(flag);
            while (!flag){
            }
        }).start();
        System.out.println(" AAAAAAAAA ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" BBBBBBB ");
        flag = true;
    }


}
