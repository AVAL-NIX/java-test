package 字符串集合AA.判断素素;

/**
 * 字符串集合AA.判断素素
 * @author zhengxin
 * @date 2021/4/18
 */
public class Susu {


    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        System.out.println(isSus(10000));
        long e1 = System.currentTimeMillis();
        System.out.println(" 用时：" + (e1-b));
        System.out.println(isSus2(10000));
        long e2= System.currentTimeMillis();
        System.out.println(" 用时： " + (e2-e1));
    }

    /**
     * 埃筛法，
     * 1. 主要先判断所有的都是素数， 创建一个boolean数组
     * 2. 然后找一个素数， 将它* 1  但是要少于N    比如  ： 2 是素数，  然后将 2* 3 2*4   2*5 放进去。
     * @param list
     * @return
     */
    private static int isSus2(int n) {
        // 空间换时间
        boolean[] arr = new boolean[n]; // false 为素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(!arr[i]){
                count ++;
                // 标记合数， 也就是非素素
                // 2* i 可以 换成 i*i
                // 为什么？  因为2是素素2*2  2*3  2*4 在 3是素素中， 又从2开始 2*3 已经放进去过一次了， 不对。要从3开始，  所以要从自己开始。

                    for (int j = i * i ; j < n ; j+= i ) {
                        try {
                        arr[j] = true;
                        } catch (Exception e) {
                            System.out.println(i);
                            System.out.println(j);
                        } finally {
                        }
                    }

            }
        }
        return count;
    }

    /**
     * 暴力解法
     * @param list
     * @return
     */
    public static int isSus(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isResult(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isResult(int x) {
        /**
         * 这里可以做优化， 直接
         * 12 为例子
         * 12 = 2 *6    6*2
         * 6*2是没有必要的判断
         * 所以，这里只要 i1 < 根号 x 就行了，
         * 简化为
         * i1 * i1 <= n
         */
        for (int i1 = 2; i1 < x; i1++) {
            if (x % i1 == 0) {
                return false;
            }
        }
        return true;
    }




}
