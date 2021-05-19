package 查找算法集合AA.牛牛分蛋糕;

/**
 * 牛牛今天家里要来客人，所以牛牛今天特意做了他最拿手的两种蛋糕，但是他是一个有洁癖的人，所以他在分蛋糕时，有如下几个原则：
 * 1.他不希望一个盘子里出现两种蛋糕
 * 2.他希望每个盘子中都有蛋糕
 * 3.他想让装有最少蛋糕数量的盘子中装有的蛋糕数量尽可能多
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 处理函数，返回在所有分法中，蛋糕数量最少的盘子中分到最多的蛋糕数量
     *
     * @param n int整型 n个盘子
     * @param a int整型 a蛋糕数量
     * @param b int整型 b蛋糕数量
     * @return int整型
     */
    public int splitCake(int n, int a, int b) {
        if (a + b == n) {
            return 1;
        }
        //标准2分框架 ， 套就完事了
        int left = 0, right = a + b;
        while (left < right) {
            int mid = left + (int)Math.ceil((right - left) / 2.0);
            if (check(mid, n, a, b)) {
                //够分的话 ， 缩小左侧区间
                left = mid;
            } else {
                //这里为什么是-1 ？  因为  mid肯定是不够分的， 所以值要减少
                right = mid - 1;
            }
        }
        //返回left , right 随便那个。
        return left;

    }

    /**
     * 是否够分？ true 够 。
     *
     * @param mid 最少值
     * @param n   盘子数
     * @param a  A 蛋糕数量
     * @param b  B 蛋糕数量
     * @return
     */
    private boolean check(int mid, int n, int a, int b) {
        int count = 0;
        while (a - mid >= 0){
            a -= mid;
            count++;
        }
        while (b - mid >= 0){
            b -= mid;
            count++;
        }
        //如果count数量大于 盘子数， 说明是够分的。
        return count >= n ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitCake(4,7,10));
    }
}
