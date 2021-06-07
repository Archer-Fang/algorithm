package PartThree.leetcode.editor.cn.q146LruCache;

import java.util.*;

//Java：LRU 缓存机制
public class q146LruCache{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(8);
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity;
    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size()>this.capacity;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
