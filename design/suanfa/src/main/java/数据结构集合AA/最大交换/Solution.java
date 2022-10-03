package 数据结构集合AA.最大交换;

class Solution {
    public int maximumSwap(int num) {
        String t = String.valueOf(num);
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            char max = t.charAt(i);
            boolean flag = false;
            for (int j = 0; j < t.length(); j++) {
                if(max < t.charAt(j)){
                    max = t.charAt(j);
                    flag = true;
                }
            }
            if(flag){
                return 11;
            }
        }
        return Integer.parseInt(result);
    }
}