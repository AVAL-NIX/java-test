package 数据结构集合AA.数组中数字出现的次数;

class Solution {
    /**
     * 条件
     *
     * 1.两个只出现一次的数字在不同的组中；
     * 2.相同的数字会被分到相同的组中。
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        // 获取  a b 异或结果
        //   a = 2 , b = 7
        // 10    111
        //  result = 101   
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r ^= nums[i];
        }
        //在异或结果中找到任意为 1 的位。
        // A , B 异或结果 相同为0        (  不同为1  )
        // 如果  a ^ b  = 101
        // 101 & div == 0
        // div = 010
        int div = 1;
        while ((div & r) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            //两个相同的数字的对应位都是相同的，所以一个被分到了某一组，另一个必然被分到这一组，所以满足了条件 2。
            // 1 & 10 = 0
            // 1 & 111 = 1
            // 所以AB被分组了
            if ((div & nums[i]) != 0) {
                a ^= nums[i];
            } else {
                //  不等，根据这个方法的定义「如果该位为 0 就分到第一组，否则就分到第二组」可以知道它们被分进了两组，所以满足了条件 1。
                b ^= nums[i];
            }

        }
        res[0] = a;
        res[1] = b;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumbers(new int[]{5,5,2,7}));
    }
}