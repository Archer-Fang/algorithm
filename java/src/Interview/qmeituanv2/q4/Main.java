package Interview.qmeituanv2.q4;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 11:08
 **/

 import java.util.HashSet;

class Solution {
     public int needNum(int n,int k, int[][] nums) {
         HashSet<Integer> set=new HashSet<>();
         for (int i=0;i<n;i++){
             for (int j=0;j<n;j++){
                 set.add(nums[i][j]);
             }
         }
         if(set.size()!=n) return -1;
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
     public int dfs(int[][] nums,int x,int y,int n,int start,int k,int d){
         if(start==k){
             return d;
         }
         int min=Integer.MAX_VALUE;
         for (int i=0;i<n;i++){
             for (int j=0;j<n;j++){
                 if(nums[i][j]==start+1){
                     d+=Math.abs(i-x)+Math.abs(j-y);
                     min=Math.min(min,dfs(nums,i,j,n,start+1,k,d));
                 }
             }
         }
         return min;
     }
 }

 public class Main {
     public static void main(String[] args) {
         Solution solution = new Solution();
//         Scanner in = new Scanner(System.in);
//         String[] ss1 = in.nextLine().split(" ");
//         int[] d1 = new int[ss1.length];
//         for (int i = 0; i < ss1.length; i++) {
//             d1[i] = Integer.parseInt(ss1[i]);
//         }
//
//         int[][] d = new int[d1[0]][d1[0]];
//         for (int i=0;i<d1[0];i++){
//             String[] ss = in.nextLine().split(" ");
//             for (int j = 0; j < ss.length; j++) {
//                 d[i][j] = Integer.parseInt(ss[j]);
//             }
//         }
//
//         System.out.println(solution.needNum(d1[0],d1[1], d));

         System.out.println(solution.needNum(4,4, new int[][]{{1,2,2,1},{2,4,4,1},{4,4,4,2},{1,1,1,2}}));
         System.out.println(solution.needNum(3,3, new int[][]{{1,2,1},{2,1,2},{1,3,2}}));
     }
 }