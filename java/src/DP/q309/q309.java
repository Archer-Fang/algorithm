package DP.q309;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 11:38
 **/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        if(prices.length==2)return prices[1]-prices[0]>0? prices[1]-prices[0]:0;
        int[] buy=new int[prices.length];
        int[] sell=new int[prices.length];
        buy[0]=-prices[0];
        buy[1]=Math.max(-prices[0],-prices[1]);
        sell[0]=0;
        sell[1]=Math.max(sell[0],buy[0]+prices[1]);
        for (int i=2;i<prices.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return buy[prices.length-1]>sell[prices.length-1]? buy[prices.length-1]:sell[prices.length-1];
    }
}

public class q309 {
    public static void main(String[] args) {
       Solution solution=new Solution();
        int[] nums={1,2,3,0,2};
        System.out.println(solution.maxProfit(nums));
    }
}
