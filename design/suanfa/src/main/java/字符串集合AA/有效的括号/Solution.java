package 字符串集合AA.有效的括号;

class Solution {
    public boolean isValid(String s) {
        boolean flag = true;
        while(flag){
            int len = s.length();
            s=s.replace("()","");
            s=s.replace("[]","");
            s=s.replace("{}","");
            if(len == s.length()){
                flag=false;
            }
        }
        return s.length() == 0;
    }
}