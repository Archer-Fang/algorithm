package nowcoder.meituan.ten.q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/9 21:41
 **/
public class Main {
    public static void main(String[] args) {
        //5
        //7 6 5 1 3
        //左跟右
        int n=310;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k]=-1;
                }
            }
        }
        //以根为节点到左右子树的加权值
        //l+r+dp[i]*dp[p]
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] numsSource = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] nums= new int[numsSource.length+1];
        for (int i = 0; i < numsSource.length; i++) {
            nums[i+1]=numsSource[i];
        }
        int ans=dp(1,nums.length-1,0,nums,dp);
        System.out.println(ans);
    }

    private static int dp(int l, int r, int p, int[] nums,int[][][] dp) {
        if(l>r) return 0;
        if(dp[l][r][p]!=-1) return dp[l][r][p];
        int ans=Integer.MAX_VALUE;
        for (int i = l; i <=r ; i++) {
            int left=dp(l,i-1,i,nums,dp);
            int right=dp(i+1,r,i,nums,dp);
            ans=Math.min(ans,left+right+nums[i]*nums[p]);
        }
        dp[l][r][p]=ans;
        return dp[l][r][p];

    }
}



