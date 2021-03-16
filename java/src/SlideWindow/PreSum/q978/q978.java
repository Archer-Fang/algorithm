//package SlideWindow.PreSum.q978;
//
///**
// * @author Created by Fangzj
// * @data 2021/3/16 22:00
// **/
//class Solution {
//    public int maxTurbulenceSize(int[] arr) {
//        int[] sum=new int[arr.length+1];
//        for (int i=2;i<sum.length;i++){
//            sum[i]=arr[i-1]-arr[i-2];
//        }
//        if(sum[2]<0) sum[1]=1;
//        if(sum[2]>0) sum[1]=-1;
//
//
//    }
//}
//public class q978 {
//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        System.out.println(solution.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
//    }
//}
