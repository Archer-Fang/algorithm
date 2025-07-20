#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
# 
#  计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
# 
#  你可以认为每种硬币的数量是无限的。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：coins = [1, 2, 5], amount = 11
# 输出：3 
# 解释：11 = 5 + 5 + 1 
# 
#  示例 2： 
# 
#  
# 输入：coins = [2], amount = 3
# 输出：-1 
# 
#  示例 3： 
# 
#  
# 输入：coins = [1], amount = 0
# 输出：0
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= coins.length <= 12 
#  1 <= coins[i] <= 2³¹ - 1 
#  0 <= amount <= 10⁴ 
#  
# 
#  Related Topics 广度优先搜索 数组 动态规划 👍 3079 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i]]+1)
        dp=[999999999999999999999 for i in range(amount+1)]
        dp[0]=0
        for i in range(len(coins)):
            for j in range(coins[i],amount+1):
                dp[j]=min (dp[j],dp[j-coins[i]]+1)
        # if amount==0:
        #     return 0
        if dp[amount]==999999999999999999999:
            return -1
        return dp[amount]
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.coinChange(coins = [1], amount = 0))