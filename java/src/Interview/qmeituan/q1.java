//package Interview.qmeituan;
//
///**
// * @author Created by Fangzj
// * @data 2021/3/29 13:53
// **/
//
//import java.util.Arrays;
//import java.util.Scanner;
//class Solution{
//    public int getN(int n,int x,int y,int[] inputs){
//        Arrays.sort(inputs);
//        for (int i=0;i<inputs.length;i++){
//            if((i+1)>=x&&(i+1)<=y&&(inputs.length-1-i)>=x&&(inputs.length-1-i)<=y){
//                return inputs[i];
//            }
//        }
//        return -1;
//    }
//}
//public class q1 {
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String[] input1=in.nextLine().split(" ");
//        int[] input11=new int[input1.length];
//        for (int i=0;i<input1.length;i++){
//            input11[i]=Integer.parseInt(input1[i]);
//        }
//        String[] input2=in.nextLine().split(" ");
//        int[] input22=new int[input2.length];
//        for (int i=0;i<input2.length;i++){
//            input22[i]=Integer.parseInt(input2[i]);
//        }
//        Solution solution=new Solution();
//        System.out.println(solution.getN(input11[0],input11[1],input11[2],input22));
////        Solution solution=new Solution();
////        System.out.println(solution.getN(6,2,3,new int[]{1,2,3,4,5,6}));
//
//    }
//
//}
