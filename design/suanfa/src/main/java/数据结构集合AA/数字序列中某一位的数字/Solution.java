package 数据结构集合AA.数字序列中某一位的数字;

class Solution {
    /**
     * 一位数一共有9个数即 9 × 1 个数字
     * 二位数一共有90个数即 90 × 2 个数字
     * 三位数一共有900个数即 900 × 3 个数字
     * ······
     * 发现规律：
     * 设数字number，digit表示其为几位数，start表示该为位数的起始第一个数是多少（比如二位数起始第一个数字为10）。则该数字所在位数的所有数包含的数字个数为：count = digit * start * 9。
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;   // 数字长度 ， 比如 10 是2
        long start = 1;   // 每 digit 位数的起始数字（即：1, 10, 100, \cdots1,10,100,⋯），记为 startstart 。
        long count = digit * start * 9;
        //如果超过2位数 及以上
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        //得到 count 是整个串
        //判断第n位数字属于哪一个数
        long number = start + (n - 1) / digit;  // (n -1 ) / digit = 10 = 1,1 , 11 = 2,2

        //3、判断第n位数字在第二步找出的数中是第几位
        String s = number + "";
        return Integer.parseInt(String.valueOf(s.charAt((n - 1) % digit))) ;
    }
}