#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定两个单词 word1 和
#  word2 ，返回使得
#  word1 和 
#  word2 相同所需的最小步数。 
# 
#  每步 可以删除任意一个字符串中的一个字符。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入: word1 = "sea", word2 = "eat"
# 输出: 2
# 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
#  
# 
#  示例 2: 
# 
#  
# 输入：word1 = "leetcode", word2 = "etco"
# 输出：4
#  
# 
#  
# 
#  提示： 
#  
# 
#  
#  1 <= word1.length, word2.length <= 500 
#  word1 和 word2 只包含小写英文字母 
#  
# 
#  Related Topics 字符串 动态规划 👍 738 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if len(word1)==0:
            return len(word2)
        if len(word2)==0:
            return len(word1)
        if word1==word2:
            return 0
        dp=[[0]*len(word2) for i in range(len(word1))]
        for i in range(len(word1)):
            if word2[0]==word1[i]:
                dp[i][0]=1
            else:
                dp[i][0]=max(dp[i-1][0],dp[i][0])
        for j in range(len(word2)):
            if word1[0]==word2[j]:
                dp[0][j]=1
            else:
                dp[0][j]=max(dp[0][j-1],dp[0][j])

        for i in range(1,len(word1)):
            for j in range(1,len(word2)):
                if word1[i]==word2[j]:
                    dp[i][j]=max(dp[i-1][j-1]+1,dp[i][j])
                else:
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1])
        return len(word2)+len(word1)-2*dp[-1][-1]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.minDistance(word1 = "sea", word2 = "eat"))