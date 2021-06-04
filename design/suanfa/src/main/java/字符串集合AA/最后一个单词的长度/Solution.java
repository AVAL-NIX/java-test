package 字符串集合AA.最后一个单词的长度;

class Solution {
    public int lengthOfLastWord(String s) {
        if("".equals(s.trim())){
            return 0 ;
        }
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }
}