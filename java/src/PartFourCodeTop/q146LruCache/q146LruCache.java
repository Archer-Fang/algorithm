package PartFourCodeTop.q146LruCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//Java：LRU 缓存机制
public class q146LruCache{
    public static void main(String[] args) {

        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private LinkedHashMap<Integer, Integer> integerIntegerLinkedHashMap = new LinkedHashMap<Integer, Integer>();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(integerIntegerLinkedHashMap.containsKey(key)){
            int v=integerIntegerLinkedHashMap.get(key);
            integerIntegerLinkedHashMap.remove(key);
            integerIntegerLinkedHashMap.put(key,v);
            return v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(integerIntegerLinkedHashMap.containsKey(key)){
            integerIntegerLinkedHashMap.remove(key);
        }else if(integerIntegerLinkedHashMap.size()==capacity){
            Iterator<Map.Entry<Integer, Integer>> iterator = integerIntegerLinkedHashMap.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        integerIntegerLinkedHashMap.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
