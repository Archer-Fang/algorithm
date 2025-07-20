#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：n = 3
# 输出：5
#  
# 
#  示例 2： 
# 
#  
# 输入：n = 1
# 输出：1
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 19 
#  
# 
#  Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2642 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numTrees(self, n: int) -> int:
        dp=[0 for i in range(n+2)]
        dp[0]=1
        dp[1]=1
        dp[2]=2
#         dp[3]=dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]
#         dp[4]=dp[0]*dp[3]+dp[1]*dp[2]+dp[2]*dp[1]+dp[3]*dp[0]
        for i in range(3,n+2):
            for j in range(0,i):
                dp[i]+=dp[j]*dp[i-1-j]
        return dp[n]

# leetcode submit region end(Prohibit modification and deletion)

# dp[i]=max(dp[i-w]+v,dp[i-1])
if __name__ == '__main__':
    s=Solution()
    print(s.numTrees(3))