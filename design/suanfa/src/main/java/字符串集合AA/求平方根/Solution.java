package 字符串集合AA.求平方根;


public class Solution {
    /**
     * 二分法
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }

        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            if (mid * mid == x || ((mid * mid < x) && ((mid + 1) * (mid + 1) > x))) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else if (mid * mid > x) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 牛顿迭代。 。  x = n的平方 ，  (x/n + n) /2 = 他的平方根 。 。 。 这是一个公式在这里不举例了 。
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt2(int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }

        return newton(x, x);
    }

    public int newton(double i, int x) {
        double res = (x / i + i) / 2;
        if (res == i) {
            return (int) res;
        } else {
            return newton(res, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sqrt2(1518991037));
    }
}
