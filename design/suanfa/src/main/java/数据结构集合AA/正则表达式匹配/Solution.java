package 数据结构集合AA.正则表达式匹配;

class Solution {
    public boolean isMatch(String s, String p) {
        for (int j = 0; j < p.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                int begin = i;
                while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                String temp = s.substring(begin, i + 1);
                if (!match(temp, p, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int index = 0;

    /**
     * 
     * @param m 要匹配的字符串
     * @param p 可以匹配的字符串
     * @param start
     * @return
     */
    public boolean match(String m, String p, int start) {

        for (int i = start; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c == '.'){
                continue;
            }
        }

        return true;
    }
}