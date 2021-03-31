package PartOne.Heap.q1738;

import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/23 10:10
 **/
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int ans=0;
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++) {
                dp[i][j]=dp[i][j-1]^dp[i-1][j]^dp[i-1][j-1]^matrix[i-1][j-1];
                minHeap.add(dp[i][j]);
                while (minHeap.size()>k){minHeap.poll();}
            }
        }

        return minHeap.peek();
    }
}
public class q1738 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.kthLargestValue(new int[][]{{5,2},{1,6}},1));
        System.out.println(solution.kthLargestValue(new int[][]{{5,2},{1,6}},2));
        System.out.println(solution.kthLargestValue(new int[][]{{5,2},{1,6}},3));
        System.out.println(solution.kthLargestValue(new int[][]{{5,2},{1,6}},4));
    }
}
