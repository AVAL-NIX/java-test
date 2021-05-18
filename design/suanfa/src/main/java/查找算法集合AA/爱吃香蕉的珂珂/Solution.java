package 查找算法集合AA.爱吃香蕉的珂珂;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 最大值肯定是符合H的 ， 因为H大于piles.length
        int max = getMax(piles);
        for (int speed = 1; speed < max; speed++) {
            // 以 speed 是否能在 H 小时内吃完香蕉
            if (canFinish(piles, speed, h)) {
                return speed;
            }
        }
        return max;
    }

    public int minEatingSpeed2(int[] piles, int h) {
        // 最大值肯定是符合H的 ， 因为H大于piles.length
        int left = 0, right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 以 speed 是否能在 H 小时内吃完香蕉
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        //按照speed速度能吃完香蕉的时间
        int minH = 0;
        for (int i = 0; i < piles.length; i++) {
            double size = piles[i];
            minH += Math.ceil(size / speed);
        }
        if (minH <= h) {
            return true;
        }
        return false;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }


}
