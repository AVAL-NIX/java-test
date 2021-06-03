package 数据结构集合AA.设计LRU缓存结构;

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
            //如果值不为空更新最近的KEY
            updateLessKey(key);
        }
        return result;
    }

    public void put(int key, int value) {
        hash.put(key, value);
        //如果容量超标
        if (hash.size() > capacity) {
            //删除最近的KEY
            hash.remove((Object) getLessKey());
        }
        //更新最近的KEY
        updateLessKey(key);
    }

    //获取最近的KEY ， 因为链表是队列的一种， 所以取对尾
    public int getLessKey() {
        int key = list.getLast();
        return key;
    }

    //  //更新最近的KEY
    public void updateLessKey(int key) {
        // 如果重复了， 先删除， 在添加
        if (list.contains(key)) {
            list.remove((Object) key);
        }
        list.addFirst(key);
        // 队列超标了也删除最后的。
        if (list.size() > capacity) {
            list.removeLast();
        }
    }

}



