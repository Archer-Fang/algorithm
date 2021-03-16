package SlideWindow.PreSum.q1109;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 16:55
 **/
class Solution {
    //暴力
//    public int[] corpFlightBookings(int[][] bookings, int n) {
//        int[] sum=new int[n];
//        for (int[] item:bookings){
//            for (int i=item[0]-1;i<item[1];i++){
//                sum[i]+=item[2];
//            }
//        }
//        return sum;
//    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] v=new int[n];
        int[] sum=new int[n];
        for (int[] item:bookings){
            v[item[0]-1]+=item[2];
            if(item[1]<n) v[item[1]]-=item[2];
        }
        sum[0]=v[0];
        for (int i=1;i<n;i++){
            sum[i]=sum[i-1]+v[i];
        }
        return sum;
    }
}
public class q1109 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5));
    }
}
