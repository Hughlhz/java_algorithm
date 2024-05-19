package hot100.linkedlist;

import annotations.Star;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@Star("通过java中hashmap的子类linkedhashmap来做，这个map中会根据插入顺序或者使用顺序构建双向链表；")
// 一个更简洁的做法
public class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


//public class LRUCache {
//    private final int capacity;
//    private final Map<Integer, Integer> cache = new LinkedHashMap<>(); // 自带双向链表
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) { // key 不在 cache 中
//            return -1;
//        }
//        int value = cache.remove(key);
//        cache.put(key, value); // 把 key 移到链表末尾
//        return value;
//    }
//
//    public void put(int key, int value) {
//        if (cache.remove(key) != null) { // key 在 cache 中
//            cache.put(key, value); // 把 key 移到链表末尾
//            return;
//        }
//        if (cache.size() == capacity) { // cache 满了
//            int oldestKey = cache.keySet().iterator().next();
//            cache.remove(oldestKey); // 移除最久未使用 key
//        }
//        cache.put(key, value);
//    }
//}
