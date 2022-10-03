package 数据结构集合AA.重新格式化电话号码;

class Solution {
    public String reformatNumber(String number) {
        StringBuffer newNumber = new StringBuffer();
        for (int i = 0; i < number.length(); i++) {
            char v = number.charAt(i);
            if (v != ' ' && v != '-') {
                newNumber.append(v);
            }
        }

        if (newNumber.length() < 4) {
            return newNumber.toString();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < newNumber.length(); i++) {
            if (newNumber.length() - i > 4) {
                for (int j = 0; j < 3; j++) {
                    char c = newNumber.charAt(i);
                    result.append(c);
                    i++;
                }
                result.append("-");
                i--;
            } else if (newNumber.length() - i == 4) {
                for (int j = 0; j < 2; j++) {
                    char c = newNumber.charAt(i);
                    result.append(c);
                    i++;
                }
                result.append("-");
                i--;
            } else {
                char c = newNumber.charAt(i);
                result.append(c);
            }

        }
        return result.toString();
    }
}