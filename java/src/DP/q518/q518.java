package DP.q518;

/**
 * @author Created by Fangzj
 * @data 2021/3/9 20:53
 **/

class Solution {

    public int change(int amount, int[] coins) {
        int[] c=new int[amount+1];
        c[0]=1;

        for(int i=0;i<coins.length;i++){
            for (int j=1;j<=amount;j++){
                if(j>=coins[i]){
                    c[j]+=c[j-coins[i]];
                }

            }
        }
        return c[amount];
    }
}

public class q518 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        int[] coins={1,2,5};
        int[] coins={2};
        System.out.println(solution.change(3,coins));
    }
}
