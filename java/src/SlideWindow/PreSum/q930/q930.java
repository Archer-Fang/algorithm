package SlideWindow.PreSum.q930;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 14:16
 **/
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (S<1) return atMost(A,S);
        return atMost(A,S)-atMost(A,S-1);
    }
    public int atMost(int[] A, int S) {
        //找到所有和小于等于S的子数组的最长长度
        int L=0;
        int max=0;
        for (int i=0;i<A.length;i++){
            S-=A[i];
            while (S<0){
                S+=A[L++];
            }
            max+=i-L+1;
        }

        return max;
    }
}

public class q930 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1,0,1,0,1},2));
        System.out.println(solution.numSubarraysWithSum(new int[]{1,1,2,1,1},3));
    }
}
