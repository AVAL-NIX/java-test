package week.有效时间的数目;

class Solution {
    public int countTime(String time) {
        String[] split = time.split(":");
        String hours = split[0];
        String min = split[1];
        int result = 0;


        if (hours.equals("??")) {
            result = 24;
        } else if (hours.charAt(0) == '?') {
            char v = hours.charAt(0);
            for (int i = 0; i < 3; i++) {
                String newStr = "" + i + hours.charAt(1);
                if (is24Ture(newStr)) {
                    result++;
                }
            }
        } else if (hours.charAt(1) == '?') {
            char r = hours.charAt(1);
            for (int i = 0; i < 10; i++) {
                String newStr = "" + hours.charAt(0) + i;
                if (is24Ture(newStr)) {
                    result++;
                }
            }
        }

        int result2 = 0;
        if (min.equals("??")) {
            result2 = 60;
        } else if (min.charAt(0) == '?') {
            char v = min.charAt(0);
            for (int i = 0; i < 6; i++) {
                String newStr = "" + i + min.charAt(1);
                if (is60Ture(newStr)) {
                    result2++;
                }
            }
        } else if (min.charAt(1) == '?') {
            char r = min.charAt(1);
            for (int i = 0; i < 10; i++) {
                String newStr = "" + min.charAt(0) + i;
                if (is60Ture(newStr)) {
                    result2++;
                }
            }
        }

        return (result == 0 ? 1 : result) * (result2 == 0 ? 1 : result2);
    }

    public boolean is24Ture(String a) {
        int i = Integer.parseInt(a);
        if (i >= 0 && i < 24) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is60Ture(String a) {
        int i = Integer.parseInt(a);
        if (i >= 0 && i < 60) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countTime("0?:0?"));
    }
}