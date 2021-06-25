package 字符串集合AA.翻转字符串里的单词;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = arr.length- 1; i >= 0 ; i--) {
            if(arr[i] == null || arr[i].equals("")) continue;
            sb.append(arr[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}