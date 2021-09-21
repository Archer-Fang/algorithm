package PartOneReWrite.Heap.q973KClosestPointsToOrigin;

import java.util.PriorityQueue;

//Java：最接近原点的 K 个点
public class q973KClosestPointsToOrigin{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.kClosest(new int[][]{{1,3},{-2,2}},1);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Item> maxHeap = new PriorityQueue<Item>((a, b) -> Double.compare(b.distance,a.distance));
        for (int i = 0; i < points.length; i++) {
            double d = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            if(maxHeap.size()==k&&d<maxHeap.peek().distance) maxHeap.poll();
            if(maxHeap.size()<k){
                maxHeap.add(new Item( d,points[i][0],points[i][1]));
            }
        }
        int[][] ans = new int[k][2];
        int i=0;
        while (!maxHeap.isEmpty()){
            Item poll = maxHeap.poll();
            ans[i++]=new int[]{poll.x,poll.y};
        }
        return ans;


    }
    class Item{
        double distance;
        int x;
        int y;

        public Item(double distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
