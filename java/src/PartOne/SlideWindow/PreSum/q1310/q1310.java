package PartOne.SlideWindow.PreSum.q1310;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 20:36
 **/
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] sum=new int[arr.length+1];
        for (int i=1;i<arr.length+1;i++){
            sum[i]=sum[i-1]^arr[i-1];
        }
        int[] result=new int[queries.length];
        int i=0;
        for (int[] query:queries){
            result[i++]=sum[query[1]+1]^sum[query[0]];
        }
        return result;
    }
}
public class q1310 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.xorQueries(new int[]{16},new  int[][]{{0,0},{0,0},{0,0}}));
    }
}
