import java.util.Arrays;

/**
 * 原始数组                  : 1 2 3 4 5 6 7
 * 反转所有数字后             : 7 6 5 4 3 2 1
 * 反转前 k 个数字后          : 5 6 7    4 3 2 1
 * 反转后 n-k 个数字后        : 5 6 7    1 2 3 4 --> 结果
 *
 * @author zhengxin
 * @date 2021/3/17
 */
public class IntRight {

    public static void main(String[] args) {
//        将每个整数循环向右移
        int[] b = solve(6, 2, new int[]{1, 2, 3, 4, 5, 6});
        System.out.print(Arrays.toString(b));
    }


    /**
     * 数组集合.旋转数组 , 不使用额外的数组
     *  * 原始数组                  : 1 2 3 4 5 6 7
     *  * 反转所有数字后             : 7 6 5 4 3 2 1
     *  * 反转前 k 个数字后          : 5 6 7    4 3 2 1
     *  * 反转后 n-k 个数字后        : 5 6 7    1 2 3 4 --> 结果
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public static int[] solve(int n, int m, int[] a) {
        // 移动M 位 。 肯定是 index 是要移走的位置。
        int k = m % n;
        reveive(a, 0, n - 1);
        reveive(a, 0, k - 1);
        reveive(a, k, n - 1);
        return a;
    }

    private static void reveive(int[] a, int s, int e) {
        while (s < e) {
            int t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }
}
