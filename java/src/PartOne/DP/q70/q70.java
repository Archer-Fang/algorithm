package PartOne.DP.q70;

/**
 * @author Created by Fangzj
 * @data 2021/3/10 16:22
 **/
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int [] all=new int[n+1];
        all[1]=1;
        all[2]=2;
        for (int i=3;i<=n;i++){
            all[i]=all[i-1]+all[i-2];
        }
        return all[n];
    }
}
public class q70 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        int[] coins={1,2,5};
        int[] coins={2};
        System.out.println(solution.climbStairs(3));
    }
}
