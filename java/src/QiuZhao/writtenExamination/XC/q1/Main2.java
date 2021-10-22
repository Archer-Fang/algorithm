package QiuZhao.writtenExamination.XC.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 18:56
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        int cnt=0;
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        Arrays.fill(dp[1],Integer.MAX_VALUE);
        dp[0][0]=0;
        dp[1][0]=0;
        char[] chars = s.toCharArray();
        if(chars[0]>='a'&&chars[0]<='z'){
            dp[1][0]=1;
        }else {
            dp[0][0]=1;
        }
        for (int i = 1; i < n; i++) {
            if(Character.toLowerCase(chars[i])!=Character.toLowerCase(chars[i-1])){
                if(chars[i]>='a'&&chars[i]<='z'){
                    dp[0][i]=Math.min(dp[0][i-1],dp[1][i-1]);
                    dp[1][i]=Math.min(dp[0][i-1],dp[1][i-1])+1;
                }else {
                    dp[0][i]=Math.min(dp[0][i-1],dp[1][i-1])+1;
                    dp[1][i]=Math.min(dp[0][i-1],dp[1][i-1]);
                }

            }else if(chars[i]>='a'&&chars[i]<='z'){
                dp[0][i]=Math.min(dp[0][i],dp[1][i-1]);
                dp[1][i]=Math.min(dp[1][i],dp[0][i-1]+1);
            }else {
                dp[0][i]=Math.min(dp[0][i],dp[1][i-1]+1);
                dp[1][i]=Math.min(dp[1][i],dp[0][i-1]);
            }
        }
        System.out.println(Math.min(dp[1][dp[1].length-1],dp[0][dp[0].length-1]));


    }
}
