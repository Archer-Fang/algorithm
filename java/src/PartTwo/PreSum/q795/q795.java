package PartTwo.PreSum.q795;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 19:35
 **/
class Solution {
    //2, 1, 4, 3  R=3
    //2 1 2,1 4
    public int atMostK(int[] A,int R){
        int c=0;
        int[] ans=new int[A.length];
        for (int i=0;i<A.length;i++){
            if(A[i]<=R){
                ans[i]=++c;
            }else {
                ans[i]=0;
                c=0;
            }
        }
        return Arrays.stream(ans).sum();

    }
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return atMostK(A,R)-atMostK(A,L-1);
    }
}

public class q795 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3},2,3));
    }
}
