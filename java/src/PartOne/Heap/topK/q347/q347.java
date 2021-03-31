package PartOne.Heap.topK.q347;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/25 11:08
 **/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k==0) return new int[]{};
        PriorityQueue<Item> minHeap=new PriorityQueue<Item>((a,b)->a.freq-b.freq);
        HashMap<Integer,Integer> map=new HashMap<>();
        for (Integer num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer key: map.keySet()){
            minHeap.add(new Item(map.get(key),key));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] ans=new int[k];
        int i=0;
        while (!minHeap.isEmpty()){
            ans[i++]=minHeap.poll().val;
        }
        return ans;
    }
    class Item{
        int freq;
        int val;

        public Item(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }
}
public class q347 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}
