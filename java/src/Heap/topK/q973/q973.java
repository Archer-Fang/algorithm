package Heap.topK.q973;

import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/25 11:41
 **/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k==0) return new int[][]{{}};
        PriorityQueue<Item> maxHeap=new PriorityQueue<>((a,b)->b.d-a.d);
        for (int i=0;i<points.length;i++){
            maxHeap.add(new Item(i,(int)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2))));
            if (maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] ans=new int[maxHeap.size()][2];
        int i=0;
        while (!maxHeap.isEmpty()){
            ans[i++]=points[maxHeap.poll().index];
        }
        return ans;
    }
    class Item{
        int index;
        int d;

        public Item(int index, int d) {
            this.index = index;
            this.d = d;
        }
    }
}
public class q973 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.kClosest(new int[][]{{1,3},{-2,2}},1));
    }
}
