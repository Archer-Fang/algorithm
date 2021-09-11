//package Interview.meituan.qmeituan;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @author Created by Fangzj
// * @data 2021/3/29 14:18
// **/
//class Solution{
//    public int getN(int n,int[] array){
//        Arrays.sort(array);
//        int sum=0;
//        for (int i=1;i<=n;i++){
//            sum+=Math.abs(array[i-1]-i);
//        }
//        return sum;
//    }
//}
//public class q2 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n=Integer.parseInt(in.nextLine().split(" ")[0]);
//        String[] nn=in.nextLine().split(" ");
//        int[] n2=new int[nn.length];
//        for (int i=0;i<nn.length;i++){
//            n2[i]=Integer.parseInt(nn[i]);
//        }
//
//        Solution solution=new Solution();
//        System.out.println(solution.getN(n,n2));
//    }
//}
