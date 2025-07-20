#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
# 
#  字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
# "aec"不是）。 
# 
#  进阶： 
# 
#  如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
# 码？ 
# 
#  致谢： 
# 
#  特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：s = "abc", t = "ahbgdc"
# 输出：true
#  
# 
#  示例 2： 
# 
#  
# 输入：s = "axc", t = "ahbgdc"
# 输出：false
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= s.length <= 100 
#  0 <= t.length <= 10^4 
#  两个字符串都只由小写字符组成。 
#  
# 
#  Related Topics 双指针 字符串 动态规划 👍 1182 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if len(s)==0 :
            return True
        if len(t)==0:
            return False
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

        return dp[-1][-1]==len(s)
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.isSubsequence(s = "axc", t = "ahbgdc"))