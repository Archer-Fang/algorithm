package ShiXi.tenxun.qtenxun.q5;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 21:20
 **/

import java.util.Arrays;

//https://www.icode9.com/content-4-651337.html
class Solution {
    //砝码称重问题，简单DP
    //dp[i]=1 if dp[i-num[j]]==1;
    public int needNum(int n, int m,int[] nums) {
        Arrays.sort(nums);
        int sum= Arrays.stream(nums).sum();
        int[] dp=new int[sum+1];
        dp[0]=1;
        for (int i=1;i<=sum;i++){
            for (int j=nums.length-1;j>-1;j--){
                if(i>=nums[j]&&dp[i-nums[j]]==1){
                    dp[i]=1;
                }
                if(i<nums[j]) break;
            }
        }

        int ans=Integer.MAX_VALUE;
        for (int i=1;i<=sum;i++){
            if(i%m==0&&dp[i]==1){
                ans=Math.min(ans,i/m);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Scanner in = new Scanner(System.in);
//        int T=Integer.parseInt(in.nextLine());
//        int k=0;
//        while ((T--)>0){
//            String[] ss1 = in.nextLine().split(" ");
//            int[] d1 = new int[ss1.length];
//            for (int i = 0; i < ss1.length; i++) {
//                d1[i] = Integer.parseInt(ss1[i]);
//            }
//            int[] d = new int[d1[0]];
//            String[] ss = in.nextLine().split(" ");
//            for (int i = 0; i < ss.length; i++) {
//                d[i] = Integer.parseInt(ss[i]);
//            }
//            System.out.println(solution.needNum(d1[0],d1[1],d));
//        }

//         2
//         1 3 //2
//         2
//         5 6
//         1 2 3 4 12

//         1
//         5 6
//         1 2 3 4 12
         System.out.println(solution.needNum(5,6, new int[]{1,2,3,4,12}));
    }
}
