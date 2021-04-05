package Interview.qmeituanMy.q4;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 11:08
 **/

 import java.util.Scanner;

 class Solution {
     public int needNum(int n,int k, int[][] nums) {
         int ans=Integer.MAX_VALUE;
         for (int i=0;i<n;i++){
             for (int j=0;j<n;j++){
                 if(nums[i][j]==1){
                     ans=Math.min(ans,dfs(nums,i,j,n,1,k,0));
                 }
             }
         }
         return ans==Integer.MAX_VALUE?-1:ans;
     }
     public int dfs(int[][] nums,int i,int j,int n,int start,int k,int step){
         if(i<0||i>=n||j<0||j>=n||nums[i][j]!=start){
             return Integer.MAX_VALUE;
         }
         if(start==k) return step;
         int min=Integer.MAX_VALUE;
         min=Math.min(min,dfs(nums,i+1,j,n,start+1,k,step+1));
         min=Math.min(min,dfs(nums,i-1,j,n,start+1,k,step+1));
         min=Math.min(min,dfs(nums,i,j+1,n,start+1,k,step+1));
         min=Math.min(min,dfs(nums,i,j-1,n,start+1,k,step+1));
         return min;
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
         int[][] d = new int[d1[0]][d1[0]];
         for (int i=0;i<d1[0];i++){
             String[] ss = in.nextLine().split(" ");
             for (int j = 0; j < ss.length; j++) {
                 d[i][j] = Integer.parseInt(ss[j]);
             }
         }

         System.out.println(solution.needNum(d1[0],d1[1], d));

//         System.out.println(solution.needNum(4,4, new int[][]{{1,2,2,1},{2,4,4,1},{4,4,4,2},{1,1,1,2}}));
     }
 }