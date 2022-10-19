package 数组集合AA.三等分;

class Solution {
    public static int[] threeEqualParts(int[] arr) {
        int sum = 0;
        for (int v : arr) {
            sum += v;
        }
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, arr.length - 1};
        }

        int c = sum / 3;
        int i = -1, j = -1, k = -1;
        int count = 0;
        for (int g = 0; g < arr.length; g++) {
            int v = arr[g];
            if (v == 1 && count == 0) {
                i = g;
            }
            if (v == 1 && count == c) {
                j = g;
            }
            if (v == 1 && count == c * 2) {
                k = g;
            }
            if (v == 1) {
                count++;
            }
        }

        for (; k < arr.length && arr[i] == arr[j] && arr[j] == arr[k]; ++i, ++j, ++k) {
        }
        return k == arr.length ? new int[]{i - 1, j} : new int[]{-1, -1};
    }


    public static long to10(int[] arr, int s, int e) {
        boolean headMark = false;
        int len = 0;
        long result = 0;
        for (int j = s, i = 0; j < e; j++, i++) {
            int v = arr[j];
            if (v != 0 && headMark == false) {
                // 标记有没有出现1
                headMark = true;
                len = (e - s);
            }
            if (v == 0) {
                continue;
            }
            long v10 = (long) Math.pow(2, (len - i - 1));
            result += v10;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = threeEqualParts(new int[]{1,0,1,0,1});
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}