package 实现一个跳表;

/**
 * @author zhengxin
 * @date 2021/4/20
 */
public class Test {


    public static void main(String[] args) {
        SkipList<Integer> list = new SkipList<>();
        for (int i = 0; i < 100 ; i++) {
            list.set(i,i);
        }
        
        System.out.println(list.toString());
    }
}
