package 数据结构集合AA.验证栈序列;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    /**
     * [1,2,3,4,5]
     * [4,5,3,2,1]
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(pushed[0]);
        int popIndex = 0;
        int pIndex = 1;
        while (pIndex <= pushed.length) {
            if (deque.peekLast() == (popped[popIndex])) {
                deque.pollLast();
                popIndex++;
            } else {
                if (pIndex == pushed.length && popIndex == popped.length - 1) {
                    return true;
                }
                if (pIndex < pushed.length) {
                    deque.add(pushed[pIndex]);
                }
                pIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        validateStackSequences(new int[]{
                1, 2, 3, 4, 5
        }, new int[]{4, 5, 3, 2, 1});
    }
}