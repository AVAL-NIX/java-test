package 数组集合AA.子域名访问计数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> mark = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String v = cpdomains[i];
            String[] sp = v.split(" ");
            Integer count = Integer.parseInt(sp[0]);
            String yuming = sp[1];
            boolean flag = false;
            do {
                if (flag) {
                    yuming = yuming.substring(yuming.indexOf(".") + 1, yuming.length());
                }
                flag = true;
                mark.put(yuming, mark.getOrDefault(yuming, 0) + count);
            } while (yuming.indexOf(".") > -1);
        }
        List<String> result = new ArrayList<>();
        mark.forEach((k, v) -> {
            result.add(v + " " + k);
        });
        return result;
    }

    public static void main(String[] args) {
       System.out.println( subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}