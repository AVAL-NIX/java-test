package 数组集合AA.二进制求和;

class Solution {
    public String addBinary(String a, String b) {
        String reA = reverse(a);
        String reB = reverse(b);
        int lenA = reA.length();
        int lenB = reB.length();
        int i = 0, j = 0;
        String res = "";
        boolean isUp = false;
        while (i < lenA && j < lenB) {
            char charA = reA.charAt(i);
            char charB = reB.charAt(j);
            int value = Integer.parseInt(String.valueOf(charA)) + Integer.parseInt(String.valueOf(charB));
            if (isUp) {
                value++;
            }
            if (value >= 2) {
                value %= 2;
                isUp = true;
            } else {
                isUp = false;
            }
            res = value + res;
            i++;
            j++;
        }
        while (i < lenA) {
            char charA = reA.charAt(i);
            int value = Integer.parseInt(String.valueOf(charA));
            if (isUp) {
                value++;
            }
            if (value >= 2) {
                value %= 2;
                isUp = true;
            } else {
                isUp = false;
            }
            res = value + res;
            i++;
        }
        while (j < lenB) {
            char charB = reB.charAt(j);
            int value = Integer.parseInt(String.valueOf(charB));
            if (isUp) {
                value++;
            }
            if (value >= 2) {
                value %= 2;
                isUp = true;
            } else {
                isUp = false;
            }
            res = value + res;
            j++;
        }
        if (isUp) {
            res = "1" + res;
        }
        return res;
    }

    public String reverse(String a) {
        int i = 0, j = a.length() - 1;
        char[] arr = a.toCharArray();
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }


    /**
     * 官方
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1", "111"));
    }
}