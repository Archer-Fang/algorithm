package PartThree.leetcode.editor.cn.q378KthSmallestElementInASortedMatrix;
//Java：有序矩阵中第 K 小的元素

import java.util.PriorityQueue;

public class q378KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Item> minHeap = new PriorityQueue<Item>((a,b)->a.v-b.v);
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            minHeap.add(new Item(i,0,matrix[i][0]));
        }
        while ((--k)!=0){
            Item item = minHeap.poll();
            if(item.y+1<n){
                minHeap.add(new Item(item.x,item.y+1,matrix[item.x][item.y+1]));
            }
        }
        return minHeap.poll().v;

    }
}
class Item{
    int x;
    int y;
    int v;

    public Item(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
