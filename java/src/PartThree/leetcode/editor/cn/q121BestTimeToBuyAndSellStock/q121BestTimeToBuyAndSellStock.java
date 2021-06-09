package PartThree.leetcode.editor.cn.q121BestTimeToBuyAndSellStock;
//Java：买卖股票的最佳时机
public class q121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit=Math.max(maxProfit,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
