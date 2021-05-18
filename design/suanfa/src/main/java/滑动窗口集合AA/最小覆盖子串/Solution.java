

package 滑动窗口集合AA.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {



    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> winow = new HashMap<>();
        for (char c : t.toCharArray()) {
            //统计需要出现的次数
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0 ;
        //代表window中满足need的字符个数
        int valid = 0;
        //记录长度
        int start = 0 , len = Integer.MAX_VALUE;
        while(right < s.length()){
            char add = s.charAt(right);
            right ++;
            //TODO



            while (true){
                char del = s.charAt(left);
                left++;

                //TODO
            }

        }
        return "";
    }
}
