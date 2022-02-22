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
#  Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1559 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numTrees(self, n: int) -> int:
        # n=2
        # 以1为节点的数量=左子树0个节点数量*右子树以1为节点的数量
        # 以2为节点的数量=左子树以1为节点的数量*右子树0个节点的数量

        #n=3
        #以1为节点的数量=左子树0个节点数量*右子树以2为节点的数量
        #以2为节点的数量=左子树以1为节点的数量*右子树以1为节点的数量
        #以3为节点的数量=左子树以2为节点的数量*右子树0个节点数量

        #dp[i]+=dp[i-k]*dp[k-1]
        if n==1:
            return 1
        elif n==2:
            return 2
        elif n==3:
            return 5

        dp=[0]*(n+1)
        dp[0]=1
        for i in range(1,n+1):
            for k in range(1,i+1):
                dp[i]+=dp[i-k]*dp[k-1]
        return dp[n]
# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s=Solution()
    print(s.numTrees(4))