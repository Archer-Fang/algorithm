#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个整数数组
#  prices，其中第 prices[i] 表示第 i 天的股票价格 。 
# 
#  设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
# 
#  
#  卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
#  
# 
#  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: prices = [1,2,3,0,2]
# 输出: 3 
# 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
# 
#  示例 2: 
# 
#  
# 输入: prices = [1]
# 输出: 0
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= prices.length <= 5000 
#  0 <= prices[i] <= 1000 
#  
# 
#  Related Topics 数组 动态规划 👍 1864 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 0:no op,1: hold,2: no hold in calm,3: no hold not in calm
        # dp[i][0]=dp[i-1][0]
        # dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i],dp[i-1][3]-prices[i])
        # dp[i][2]=max(dp[i-1][2],dp[i-1][1]+prices[i])
        # dp[i][3]=max(dp[i-1][3],dp[i-1][2],dp[i-1][0])
        dp = [[0] * 4 for i in range(len(prices))]
        dp[0][1] = -prices[0]
        for i in range(1, len(prices)):
            dp[i][0]=dp[i-1][0]
            dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i],dp[i-1][3]-prices[i])
            dp[i][2]=max(dp[i-1][2],dp[i-1][1]+prices[i])
            dp[i][3]=max(dp[i-1][3],dp[i-1][2],dp[i-1][0])
        return max(dp[-1][:])
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.maxProfit([1,2,4]))