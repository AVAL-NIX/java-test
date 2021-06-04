package 链表集合AA.环形链表的约瑟夫问题;

import java.util.*;


public class Solution {
    /**
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public int ysf(int n, int m) {
        LinkedList<Integer> list = new LinkedList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 1;
        int listIndex = 0;
        while (!list.isEmpty()) {
            if (index % m == 0) {
                //这里要删除
                list.remove(listIndex);
                listIndex--;
                if (list.size() == 1) {
                    break;
                }
            }
            index++;
            listIndex++;
            if (listIndex >= list.size()) {
                listIndex = 0;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ysf(5, 2));
    }
}