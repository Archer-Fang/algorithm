#coding=utf-8
from typing import List

# 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
# 
#  返回 你可以获得的最大乘积 。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: n = 2
# 输出: 1
# 解释: 2 = 1 + 1, 1 × 1 = 1。 
# 
#  示例 2: 
# 
#  
# 输入: n = 10
# 输出: 36
# 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
# 
#  
# 
#  提示: 
# 
#  
#  2 <= n <= 58 
#  
#  Related Topics 数学 动态规划 👍 712 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def integerBreak(self, n: int) -> int:
        #dp[i]=dp[k]*max(dp[i-k],i-k)
        dp=[0]*(n+1)
        dp[1]=1
        for i in range(2,n+1):
            for k in range(1,i):
                dp[i]=max(max(k*(i-k),k*dp[i-k]),dp[i])
        return dp[n]

# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s=Solution()
    print(s.integerBreak(10))
