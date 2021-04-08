package Interview.qxiechen.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/8 14:45
 **/

 import java.util.Arrays;
 import java.util.Scanner;

 class Solution {
     public int needNum(int n) {
         int[] dp=new int[n+1];
         Arrays.fill(dp,1);

         for (int k=1;k<=n;k++){
             int sum=0;
             for (int i=1;i<=Math.sqrt(k);i++){
                 if(k%i==0){
                     sum+=dp[i]*dp[n/i];
                 }
             }
             dp[k]=sum;
         }
         return dp[n];

     }
 }

 public class Main {
     public static void main(String[] args) {
         Solution solution = new Solution();
         Scanner in = new Scanner(System.in);
         String[] ss1 = in.nextLine().split(" ");
         int[] d1 = new int[ss1.length];
         for (int i = 0; i < ss1.length; i++) {
             d1[i] = Integer.parseInt(ss1[i]);
         }
         while ((d1[0]--)>0){
             int n=in.nextInt();
             System.out.println(solution.needNum(n));
         }
//
     }
 }