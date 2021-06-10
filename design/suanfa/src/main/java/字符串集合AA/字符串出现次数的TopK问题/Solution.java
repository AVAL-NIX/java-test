package 字符串集合AA.字符串出现次数的TopK问题;

import java.util.*;
import java.util.Map.Entry;


public class Solution {
    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        if (strings.length == 0) {
            return new String[0][];
        }

        //放入堆中
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }

        //放入自定义堆中
        List<Node> list = new ArrayList<>();
        for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            list.add(new Node(stringIntegerEntry.getValue(), stringIntegerEntry.getKey()));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count == o1.count) {
                    return o1.value.compareTo(o2.value);
                }
                return o1.count > o1.count ? 1 : -1;
            }
        });

        String[][] r = new String[k][];
        for (int i = 0; i < k; i++) {
            Node n = list.get(i);
            r[i] = new String[]{n.value,n.count+""};
        }
        return r;
    }

    class Node {
        int count;
        String value;

        public Node(int count, String value) {
            this.count = count;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().topKstrings(new String[]{"a", "b", "c", "b"}, 2).toString());
    }
}