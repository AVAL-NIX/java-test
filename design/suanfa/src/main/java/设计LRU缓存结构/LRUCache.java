package 设计LRU缓存结构;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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


    public int getLessKey() {
        int key = list.getLast();
        return key;
    }

    public void updateLessKey(int key) {
        if (list.contains(key)) {
            list.remove((Object) key);
        }
        list.addFirst(key);
        if (list.size() > capacity) {
            int delKey = list.removeLast();
        }
    }

    public static void main(String[] args) {
//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        System.out.println(lruCache);
        lruCache.get(2);
        lruCache.put(3, 4);
        lruCache.put(4, 4);
        lruCache.put(4, 5);
        lruCache.get(3);
        lruCache.get(4);

//        ["LRUCache","put","put","get","put","get","get"]
//[[2],[2,1],[1,1],[2],[4,1],[1],[2]]
//        lruCache.put(2,1);
//        lruCache.put(1,1);
//        lruCache.get(2);
//        lruCache.put(4,1);
//        lruCache.get(1);
//        lruCache.get(2);

    }
}



