package PartOneReWrite.Heap.q309BestTimeToBuyAndSellStockWithCooldown;
//Java：最佳买卖股票时机含冷冻期
public class q309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        if(prices.length==2) return Math.max(0,prices[1]-prices[0]);
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
//        buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
//        sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        buy[0]=-prices[0];
        buy[1]=Math.max(-prices[0],-prices[1]);
        sell[0]=0;
        sell[1]=Math.max(0,prices[1]-prices[0]);
        for (int i = 2; i < prices.length; i++) {
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return Math.max(buy[prices.length-1],sell[prices.length-1]);



    }
}
//leetcode submit region end(Prohibit modification and deletion)
