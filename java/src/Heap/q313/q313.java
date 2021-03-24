package Heap.q313;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 20:31
 **/
class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {//DP 维护多指针
        int[] dp=new int[n];
        dp[0]=1;
        int[] arr=new int[primes.length];
        for(int i=1;i<n;i++){
            dp[i]=Integer.MAX_VALUE;
            for (int j=0;j<primes.length;j++){
                dp[i]=Math.min(primes[j]*dp[arr[j]],dp[i]);
            }
            for (int j=0;j<primes.length;j++){
                if(dp[i]==primes[j]*dp[arr[j]]) arr[j]++;
            }
        }
        return dp[n-1];
    }
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        PriorityQueue<Long> minHeap=new PriorityQueue<>();
//        long ans= 1;
//        minHeap.add(ans);
//        while (n>0){
//            ans=minHeap.poll();
//            while (!minHeap.isEmpty()&&ans==minHeap.peek()) minHeap.poll();
//            n--;
//            for (Integer num:primes){
//                minHeap.add(ans*num);
//            }
//        }
//        return (int)ans;
//
//    }
}
public class q313 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }
}
