package 回溯算法AA.打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        int result = 0 ;
        Set<String> deads = new HashSet<>();
        for(String t : deadends){
            deads.add(t);
        }
        Set<String> visted = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while(!q.isEmpty()){
            int len = q.size();
            for(int i= 0 ; i < len ; i ++){
                String t = q.poll();
                System.out.println("t1:"+t);
                if(deads.contains(t)){
                    continue;
                }
                if(t.equals(target)){
                    return result;
                }
                System.out.println("t2:"+t);
                for(int j=0; j < 4; j++){
                    String u = up(t,j);
                    if(!visted.contains(u)){
                        q.offer(u);
                        visted.add(u);
                    }
                    String d = sub(t,j);
                     if(!visted.contains(d)){
                        q.offer(d);
                        visted.add(d);
                    }
                }
            }
            result++;
        }
        return -1;
    }


    public String up(String s , int i){
        char[] arr = s.toCharArray();
        if(arr[i] == '9'){
            arr[i] = '0';
        }else{
            arr[i] += 1;
        }
        return new String(arr);
    }

    public String sub(String s , int i){
        char[] arr = s.toCharArray();
        if(arr[i] == '0'){
            arr[i] = '9';
        }else{
            arr[i] -= 1;
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
    }
}