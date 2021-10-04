package DMSXL.DP.q347TopKFrequentElements;

import java.util.HashMap;
import java.util.PriorityQueue;

//Java：前 K 个高频元素
public class q347TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Item> maxHeap = new PriorityQueue<Item>((a,b)->b.count-a.count);
        for (Integer integer : map.keySet()) {
            maxHeap.add(new Item(integer,map.get(integer)));
        }
        int[] ans = new int[k];
        int i=0;
        while (i<k&&!maxHeap.isEmpty()){
            ans[i++]=maxHeap.poll().num;
        }
        return i==k?ans:new int[]{};
    }
    class Item{
        int num;
        int count;

        public Item(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
