#!/usr/bin/env python
#coding=utf-8
import math
from typing import List

# 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
# 
#  完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
#  
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：n = 12
# 输出：3 
# 解释：12 = 4 + 4 + 4 
# 
#  示例 2： 
# 
#  
# 输入：n = 13
# 输出：2
# 解释：13 = 4 + 9 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 10⁴ 
#  
# 
#  Related Topics 广度优先搜索 数学 动态规划 👍 2193 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSquares(self, n: int) -> int:
        # dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i]]+1)
        dp=[9999999999999 for j in range(n+1)]
        dp[0]=0


        for i in range(n+1):
            for j in range(i*i,n+1):
                dp[j]=min(dp[j],dp[j-i*i]+1)
        return dp[n]

# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.numSquares(1))
    print(s.numSquares(13))
