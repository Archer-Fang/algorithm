package PartTwo.qIAmYourMotherI.q632;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 14:24
 **/
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Item> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);
        int max=Integer.MIN_VALUE;
        for (int indexNum=0;indexNum<nums.size();indexNum++){
            int tmp=nums.get(indexNum).get(0);
            max=Math.max(max, tmp);
            minHeap.add(new Item(indexNum,0,tmp));
        }
        int b= (int) Math.pow(10,5);
        int a=-b;
        while (true){
            Item node=minHeap.poll();
            if(max-node.val<b-a){
                b=max;
                a=node.val;
            }
            if(node.index+1>=nums.get(node.indexNum).size()) break;
            minHeap.add(new Item(node.indexNum,node.index+1,nums.get(node.indexNum).get(node.index+1)));
            max=Math.max(nums.get(node.indexNum).get(node.index+1),max);
        }
        return new int[]{a,b};
    }
    class Item{
        private int indexNum;
        private int index;
        private int val;

        public Item(int indexNum, int index, int val) {
            this.indexNum = indexNum;
            this.index = index;
            this.val = val;
        }
    }
}
public class Main {
}
