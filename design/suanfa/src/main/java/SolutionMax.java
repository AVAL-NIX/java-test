import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class SolutionMax {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 30; i++) {
            new SolutionMax().runMultiThreadTask_WhenPutDataInConcurrentToCache_ThenNoDataLost();
        }
        System.out.println(" 跑完了。 ！！！！");
    }


    public void runMultiThreadTask_WhenPutDataInConcurrentToCache_ThenNoDataLost() throws Exception {
        long btime = System.currentTimeMillis();
        final int size = 5000;
        final ExecutorService executorService = Executors.newFixedThreadPool(50);
        SetAssociativeCache<Integer, String> cache = new SetAssociativeCache<>(5, 10000);
//        LRUCache<Integer, String> cache = new LRUCache<>( 10000);
        CountDownLatch countDownLatch = new CountDownLatch(size * 2);
        try {
            IntStream.range(0, size).<Runnable>mapToObj(key -> () -> {
                cache.set(key, "value" + key);
                countDownLatch.countDown();
            }).forEach(executorService::submit);
            IntStream.range(0, size).<Runnable>mapToObj(key -> () -> {
                cache.get(key);
                countDownLatch.countDown();
            }).forEach(executorService::submit);
            countDownLatch.await();
        } finally {
            executorService.shutdown();
        }
        System.out.println(" assertEquals" + cache.getCount() + "," + size);
        long etime = System.currentTimeMillis();
        System.out.println(" time : " + (etime - btime));
    }


    public static class SetAssociativeCache<TKey, TValue> {
        int Capacity;
        int SetSize;
        int SetCount;
        // 这里可以参考jdk 1.7 使用分段锁。 TODO
        CacheSet<TKey, TValue>[] Sets;
        List<ReentrantReadWriteLock> locks = new ArrayList<>();
//        List<ReentrantLock> locks = new ArrayList<>();

        public SetAssociativeCache(int setCount, int setSize) {
            this.SetCount = setCount;
            this.SetSize = setSize;
            this.Capacity = this.SetCount * this.SetSize;

            // Initialize the sets
            this.Sets = new CacheSet[this.SetCount];
            for (int i = 0; i < this.SetCount; i++) {
                Sets[i] = new CacheSet<>(setSize);
                locks.add(new ReentrantReadWriteLock());
//                locks.add(new ReentrantLock());
            }
        }

        /**
         * Gets the value associated with `key`. Throws if key not found.
         */
        public TValue get(TKey key) {
            int i = key.hashCode() % this.SetCount;
//            ReentrantReadWriteLock lock = this.locks.get(i);
//            ReentrantLock r = this.locks.get(i);
            try {
//                lock.readLock().lock();
//                r.lock();
                int setIndex = this.getSetIndex(key);
                CacheSet<TKey, TValue> set = this.Sets[setIndex];
                TValue value = set.getValue(key);
                return value;
            } finally {
//                lock.readLock().unlock();
//                r.unlock();
            }
        }

        /**
         * Adds the `key` to the cache with the associated value, or overwrites the existing key.
         * If adding would exceed capacity, an existing key is chosen to replace using an LRU algorithm
         * (NOTE: It is part of this exercise to allow for more replacement algos)
         */
        public void set(TKey key, TValue value) {
            System.out.println(" " + Thread.currentThread().getName() + " : " + key);
            int i = key.hashCode() % this.SetCount;
//            ReentrantReadWriteLock locck = this.locks.get(i);
//            ReentrantLock r = this.locks.get(i);
            try {
//                locck.writeLock().lock();
//                r.lock();
                int setIndex = this.getSetIndex(key);
                CacheSet<TKey, TValue> set = this.Sets[setIndex];
                set.set(key, value);
            } finally {
//                locck.writeLock().unlock();
//                r.unlock();
            }
        }

        /**
         * Returns the count of items in the cache
         */
        public int getCount() {
            int count = 0;
            for (int i = 0; i < this.Sets.length; i++) {
                count += this.Sets[i].getCount();
            }
            return count;
        }

        /**
         * Returns `true` if the given `key` is present in the set; otherwise, `false`.
         */
        public boolean containsKey(TKey key) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            return set.containsKey(key);
        }

        /**
         * Maps a key to a set
         */
        private int getSetIndex(TKey key) {
            int c = Integer.MAX_VALUE;
            int s = -1;
            return key.hashCode() % this.SetCount;
        }
    }

    /**
     * 第二种， 双向链表 + hashmap
     */
    static class CacheSet<TKey, TValue> {
        int Capacity;

        private Map<TKey, CacheItem> cache = new HashMap<TKey, CacheItem>();
        private int size;
        private int capacity;
        private CacheItem head, tail;

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public CacheSet(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new CacheItem();
            tail = new CacheItem();
            head.next = tail;
            tail.prev = head;

        }

        public TValue getValue(TKey key) {
            CacheItem node = cache.get(key);
            if (node == null) {
                return null;
            }
            try {
//                lock.readLock().unlock();
                lock.writeLock().lock();
                // 如果 key 存在，先通过哈希表定位，再移到头部
                moveToHead(node);
            } finally {
                lock.writeLock().unlock();
//                lock.readLock().lock();
            }
            return (TValue) node.value;
        }

        public void set(TKey key, TValue value) {
            try {
                lock.writeLock().lock();

                CacheItem node = cache.get(key);
                if (node == null) {
                    // 如果 key 不存在，创建一个新的节点
                    CacheItem newNode = new CacheItem(key, value);
                    // 添加进哈希表
                    cache.put(key, newNode);
                    // 添加至双向链表的头部
                    addToHead(newNode);
                    ++size;
                    if (size > capacity) {
                        // 如果超出容量，删除双向链表的尾部节点
                        CacheItem tail = removeTail();
                        // 删除哈希表中对应的项
                        cache.remove(tail.key);
                        --size;
                    }
                } else {
                    // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                    node.value = value;
                    moveToHead(node);
                }
            } finally {
                lock.writeLock().unlock();
            }

        }

        public boolean containsKey(TKey key) {
            return this.cache.containsKey(key);
        }


        public int getCount() {
            int count = 0;
            while (head != null && head.next != null && head.next != tail) {
                head = head.next;
                count++;
            }
            return count;
        }

        private void addToHead(CacheItem node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(CacheItem node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(CacheItem node) {
            removeNode(node);
            addToHead(node);
        }

        private CacheItem removeTail() {
            CacheItem res = tail.prev;
            removeNode(res);
            return res;
        }

    }

    /**
     * An internal data structure representing a single item in an N-Way Set-Associative Cache
     */
    static class CacheItem<TKey, TValue> {
        public TKey key;
        public TValue value;

        CacheItem prev;
        CacheItem next;

        public CacheItem() {
        }

        public CacheItem(TKey key, TValue value) {
            this.key = key;
            this.value = value;
        }
    }


}
