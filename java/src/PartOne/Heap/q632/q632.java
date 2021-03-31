package PartOne.Heap.q632;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/23 14:29
 **/
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int l=-10^5;
        int r=10^5;
        PriorityQueue<Item> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);
        int maxV=Integer.MIN_VALUE;
        for (int i=0;i<nums.size();i++){
            int item=nums.get(i).get(0);
            minHeap.add(new Item(item,i,0));
            maxV=Math.max(item,maxV);
        }
        while (true){
            Item node=minHeap.poll();
            if(maxV-node.val<r-l){
                r=maxV;
                l=node.val;
            }
            if(node.col==nums.get(node.row).size()-1) return new int[]{l,r};
            minHeap.add(new Item(nums.get(node.row).get(node.col + 1),node.row,node.col+1));
            maxV=Math.max(maxV,nums.get(node.row).get(node.col + 1));
        }

    }
    private class Item{
        int val;
        int row;
        int col;

        public Item(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
public class q632 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] tmp= {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
        List<List<Integer>> nums= new ArrayList<>();
        for (int i=0;i<tmp.length;i++){
            List<Integer> tmp2=new LinkedList<>();
            for (int j=0;j<tmp[i].length;j++){
                tmp2.add(tmp[i][j]);
            }
            nums.add(tmp2);
        }
        System.out.println(solution.smallestRange(nums));

    }
}
