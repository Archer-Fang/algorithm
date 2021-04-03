package PartTwo.PreSum.q1109;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 19:58
 **/
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //find vary then 1.if vary[i]==0==>vary[i]==vary[i-1]
        //v[1]=10 v[3]=-10 v[2]=20 v[4]=-20 v[2]=25+20 v[6]=-25
        int[] v=new int[n];
        int[] ans=new int[n];
        for (int i=0;i<bookings.length;i++){
            v[bookings[i][0]-1]=v[bookings[i][0]-1]+bookings[i][2];
            if(bookings[i][1]<n){
                v[bookings[i][1]]=v[bookings[i][1]]-bookings[i][2];
            }
        }

        ans[0]=v[0];
        for (int i=1;i<n;i++){
            ans[i]=v[i]+ans[i-1];
        }
        return ans;
    }
}

public class q1109 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5));
    }
}
