#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
# 
#  请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
# 
#  假设每一种面额的硬币有无限个。 
# 
#  题目数据保证结果符合 32 位带符号整数。 
# 
#  
# 
#  
#  
# 
#  示例 1： 
# 
#  
# 输入：amount = 5, coins = [1, 2, 5]
# 输出：4
# 解释：有四种方式可以凑成总金额：
# 5=5
# 5=2+2+1
# 5=2+1+1+1
# 5=1+1+1+1+1
#  
# 
#  示例 2： 
# 
#  
# 输入：amount = 3, coins = [2]
# 输出：0
# 解释：只用面额 2 的硬币不能凑成总金额 3 。
#  
# 
#  示例 3： 
# 
#  
# 输入：amount = 10, coins = [10] 
# 输出：1
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= coins.length <= 300 
#  1 <= coins[i] <= 5000 
#  coins 中的所有值 互不相同 
#  0 <= amount <= 5000 
#  
# 
#  Related Topics 数组 动态规划 👍 1413 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # def change(self, amount: int, coins: List[int]) -> int:
    #     value=[[0 for j in range(amount+1)] for i in range(len(coins))]
    #     # 初始化
    #     for item in range(amount+1):
    #         if item%coins[0]==0:
    #             value[0][item]=1
    #     # value[i][j]=max(value[i-1][j],value[i][j-coins[i]]+1)
    #     for i in range(1,len(coins)):
    #         for j in range(amount+1):
    #             if j-coins[i]>=0:
    #                 value[i][j]=value[i-1][j]+value[i][j-coins[i]]
    #             else:
    #                 value[i][j] =value[i-1][j]
    #     return value[len(coins)-1][amount]
    def change(self, amount: int, coins: List[int]) -> int:

        dp=[0 for i in range(amount+1)]
        dp[0] = 1
        # dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]]
        # dp[j]+=dp[j-coins[i]]
        for i in range(len(coins)):
            for j in range(coins[i],amount+1):
                dp[j]+=dp[j-coins[i]]
        return dp[amount]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.change(5,[1,2,5]))