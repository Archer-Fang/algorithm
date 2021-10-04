package DMSXL.DP.q146LruCache;

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
class LRUCache extends LinkedHashMap {


    LinkedHashMap<Integer, Integer> map= new LinkedHashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            int v= map.get(key);
            map.remove(key);
            map.put(key,v);
            return v;
        }

        return -1;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }else if(map.size()==capacity){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
