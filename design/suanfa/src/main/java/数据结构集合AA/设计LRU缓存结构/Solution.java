package 数据结构集合AA.设计LRU缓存结构;

import java.util.*;

public class Solution {

    class LRUCache {

        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int result = hash.getOrDefault(key, -1);
            if (result != -1) {
                updateLessKey(key);
            }
            return result;
        }

        public void put(int key, int value) {
            hash.put(key, value);
            if (hash.size() > capacity) {
                hash.remove((Object) getLessKey());
            }
            updateLessKey(key);
        }

        public boolean containsKey(int key) {
            return hash.containsKey(key);
        }

        //获取最近的KEY
        public int getLessKey() {
            int key = list.getLast();
            return key;
        }

        //更新最近的KEY
        public void updateLessKey(int key) {
            if (list.contains(key)) {
                list.remove((Object) key);
            }
            list.addFirst(key);
            if (list.size() > capacity) {
                list.removeLast();
            }
        }

    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        LRUCache lruCache = new LRUCache(k);
        List<Integer> result = new ArrayList<>();
        for (int[] operator : operators) {
            int opt = operator[0];
            if (opt == 1) {
                lruCache.put(operator[1], operator[2]);
            }
            if (opt == 2) {
                if (lruCache.containsKey(operator[1])) {
                    result.add(lruCache.get(operator[1]));
                } else {
                    result.add(-1);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


}