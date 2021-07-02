package 数组集合AA.栈的压入弹出序列;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int p2Index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.add(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[p2Index]){
                p2Index++;
                stack.pop();
            }
        }

        return p2Index == popA.length;
    }
}