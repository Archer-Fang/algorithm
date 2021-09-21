package PartOneReWrite.Heap.q1439FindTheKthSmallestSumOfAMatrixWithSortedRows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

//Java：有序矩阵中的第 k 个最小数组和
public class q1439FindTheKthSmallestSumOfAMatrixWithSortedRows{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.kthSmallest(new int[][]{{1,3,11},{2,4,6}},5));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Item> minHeap = new PriorityQueue<>((a, b) -> a.sum-b.sum);
        int initSum=0;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            initSum+=mat[i][0];
        }
        Item item1 = new Item(initSum, new int[mat.length]);
        minHeap.add(item1);
        visited.add(Arrays.toString(item1.point));
        Item item = null;
        for (int i = 0; i < k; i++) {
            item = minHeap.poll();
            for (int j = 0; j < mat.length; j++) {
                item.point[j]+=1;
                if(item.point[j]<mat[0].length&&!visited.contains(Arrays.toString(item.point))){
                    visited.add(Arrays.toString(item.point));
                    int[] newPoints = Arrays.copyOf(item.point, item.point.length);
                    int newSum=item.sum-mat[j][newPoints[j]-1]+mat[j][newPoints[j]];
                    minHeap.add(new Item(newSum,newPoints));
                }
                item.point[j]-=1;
            }
        }

        return item.sum;

    }
    class Item{
        int sum;
        int[] point;

        public Item(int sum, int[] point) {
            this.sum = sum;
            this.point = point;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
