/**
 * 求最后一座山峰
 * @author zhengxin
 * @date 2021/3/17
 */
public class IntTest {

    public static void main(String[] args) {
        int[] c = new int[]{2, 51, 12, 95, 42, 52, 76, 77, 23, 81, 71, 41, 2, 23, 43, 4, 64, 22, 71, 96, 1, 87, 51, 91, 67, 16, 58, 11, 44, 38, 63, 14, 4, 69, 88, 49, 92, 91, 9, 15, 17, 74, 21, 91, 24, 78, 62, 50, 82, 26, 53, 18, 25, 14, 94, 79, 44, 11, 36, 38, 44, 53, 9, 34, 58, 6, 50, 82, 81, 50, 36, 1, 6, 61, 9, 47, 33, 47, 84, 41, 57, 48, 73, 18};
        int[] d = new int[]{2, 4, 1, 2, 7, 8, 4};

        System.out.println(shanfeng(d));
    }

    public static int shanfeng(int[] a) {
        // write code here
        if (a == null || a.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = a.length - 1; i > 1; i--) {
            max = a[i];
            if (max >= a[i - 1]) {
                boolean flag = true;
                if (i + 1 < a.length) {
                    if (max < a[i + 1]) {
                        flag = false;
                    }
                }
                if(flag){
                    return i;
                }
            }
        }
        return -1;
    }
}
