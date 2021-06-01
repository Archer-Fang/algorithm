package PartThree.Mid.q873LengthOfLongestFibonacciSubsequence;
//Java：最长的斐波那契子序列的长度

import java.util.Arrays;

public class q873LengthOfLongestFibonacciSubsequence{
    public static void main(String[] args) {
        int[] tmp={1};
        Solution solution = new Solution();
        // TO TEST
        solution.lenLongestFibSubseq(new int[]{1,2,3});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ans=0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                int a=arr[i],b=arr[j],sum=a+b;
                int c=2;
                while (Arrays.binarySearch(arr,sum)>=0){
                    a=b;
                    b=sum;
                    sum=a+b;
                    c++;
                }
                ans=Math.max(ans,c);
            }
        }
        return ans==2?0:ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
