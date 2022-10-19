package week.反转之后的数字和;

class Solution {
    public boolean sumOfNumberAndReverse(int num) {

        for (int i = 1; i < num; i++) {
            if (i + rev(i) == num) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }

    public int rev(int i) {
        String b = i + "";
        char[] arr = b.toCharArray();
        for (int j = 0; j < b.length() / 2; j++) {
            char t = arr[j];
            arr[j] = arr[b.length() - 1 - j];
            arr[b.length() - 1 - j] = t;
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfNumberAndReverse(443));
        System.out.println(new Solution().sumOfNumberAndReverse(63));
        System.out.println(new Solution().sumOfNumberAndReverse(181));
    }
}