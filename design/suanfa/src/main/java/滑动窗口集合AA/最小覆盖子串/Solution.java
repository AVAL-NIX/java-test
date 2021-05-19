

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
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            //统计需要出现的次数
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        //代表window中满足need的字符个数
        int valid = 0;
        //记录长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char add = s.charAt(right);
            right++;
            //TODO
            // 进行窗口内数据的一系列更新
            if (need.containsKey(add)) {
                window.put(add, window.getOrDefault(add, 0) + 1);
                //校验某个字满足了条件了没。
                if (window.get(add).equals(need.get(add))) {
                    valid++;
                }
            }

            //判断是否要搜索
            while (valid == need.size()) {
                //更新最小覆盖子串 ， 判断len的
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char del = s.charAt(left);
                left++;
                //TODO
                // 进行窗口内数据的一系列更新
                if (need.containsKey(del)) {
                    if (window.get(del).equals(need.get(del))) {
                        valid--;
                    }
                    window.put(del, window.getOrDefault(del, 0) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
