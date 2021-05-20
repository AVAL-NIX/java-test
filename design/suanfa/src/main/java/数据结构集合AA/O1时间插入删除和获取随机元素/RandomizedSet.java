package 数据结构集合AA.O1时间插入删除和获取随机元素;

import java.util.*;

class RandomizedSet {

    List<Integer> table = new ArrayList<>();
    HashMap<Integer, Integer> index = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        }
        index.put(val, table.size());
        table.add(table.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!index.containsKey(val)) {
            return false;
        }
        int idx = index.get(val);
        int idx2 = table.size() - 1;
        int changeValue = table.get(idx2);

        table.set(idx, table.set(idx2, table.get(idx)));

        index.remove(val);
        table.remove(idx2);
        //更新位置
        if (index.containsKey(changeValue)) {
            index.put(changeValue, idx);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return table.get(new Random().nextInt(table.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
