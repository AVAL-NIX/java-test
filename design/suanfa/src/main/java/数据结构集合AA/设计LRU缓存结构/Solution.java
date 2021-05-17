package 数据结构集合AA.设计LRU缓存结构;

import java.util.*;


/**
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 */
public class Solution {

    LinkedList<Integer> list = new LinkedList<>();
    Map<Integer, Integer> hash = new HashMap<>();

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        List<Integer> result = new ArrayList<>();
        for (int[] operator : operators) {
            int opt = operator[0];
            if (opt == 1) {
                if (hash.size() == k) {
                    hash.remove(getLessKey());
                }
                hash.put(operator[1], operator[2]);
                updateLessKey(operator[1]);
            }
            if (opt == 2) {
                if (hash.containsKey(operator[1])) {
                    result.add(hash.get(operator[1]));
                    updateLessKey(operator[1]);
                } else {
                    result.add(-1);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int getLessKey() {
        return list.getLast();
    }

    public void updateLessKey(int key) {
        if (list.contains(key)) {
            list.remove((Object) key);
        }
        list.addFirst(key);
    }

    public static void main(String[] args) {
        for (int i : new Solution().LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3)) {
            System.out.println(i);
        }
    }


    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU2(int[][] operators, int k) {
        LRUCache<Integer,Integer> lruCache = new LRUCache(k);
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

    class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int CACHE_SIZE;

        /**
         * 传递进来最多能缓存多少数据
         *
         * @param cacheSize 缓存大小
         */
        public LRUCache(int cacheSize) {
            // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
            super(cacheSize, 0.75F, true);
            CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
            return size() > CACHE_SIZE;
        }
    }
}
