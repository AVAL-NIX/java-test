package 字符串集合AA.实现strStr;

class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }

        char[] arr = haystack.toCharArray();
        char[] need = needle.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int res = i;
            //后面的不用检查了
            if(need.length > arr.length - i){
                return -1;
            }
            for (int j = 0, count = 0; j < need.length; j++) {
                if(need[j] == arr[res]){
                    count++;
                    res++;
                }
                if(count == need.length){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello","ll"));
    }
}