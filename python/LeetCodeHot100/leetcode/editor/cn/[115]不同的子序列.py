#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。 
# 
#  测试用例保证结果在 32 位有符号整数范围内。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：s = "rabbbit", t = "rabbit"
# 输出：3
# 解释：
# 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
# rabbbit
# rabbbit
# rabbbit 
# 
#  示例 2： 
# 
#  
# 输入：s = "babgbag", t = "bag"
# 输出：5
# 解释：
# 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
# babgbag
# babgbag
# babgbag
# babgbag
# babgbag
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= s.length, t.length <= 1000 
#  s 和 t 由英文字母组成 
#  
# 
#  Related Topics 字符串 动态规划 👍 1352 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        if len(s)==0:
            return 0
        if len(t)==0:
            return len(s)
        if len(t)==1:
            if t in s:
                return 1
            else:
                return 0

        dp = [[0 for j in range(len(t))] for i in range(len(s))]
        for i in range(len(s)):
            if s[i] == t[0]:
                dp[i][0] = 1
            else:
                dp[i][0] = max(dp[i][0], dp[i - 1][0])
        for j in range(len(t)):
            if t[j] == s[0]:
                dp[0][j] = 1
            else:
                dp[0][j] = max(dp[0][j], dp[0][j - 1])

        for i in range(1, len(s)):
            for j in range(1, len(t)):
                if s[i] == t[j]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])

        return dp[-1][-1]
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.numDistinct(s = "babgbag", t = "bag"))