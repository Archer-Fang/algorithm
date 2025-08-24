#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：s = "aab"
# 输出：[["a","a","b"],["aa","b"]]
#  
# 
#  示例 2： 
# 
#  
# 输入：s = "a"
# 输出：[["a"]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= s.length <= 16 
#  s 仅由小写英文字母组成 
#  
# 
#  Related Topics 字符串 动态规划 回溯 👍 2077 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        self.backtracking(s, result,[],0)
        return result
    def backtracking(self, s, result,path,index):
        if index==len(s):
            result.append(path[:])
            return
        for i in range(index,len(s)):
            if not self.isValid(s,index,i):
                continue
            path.append(s[index:i+1])
            self.backtracking(s, result,path,i+1)
            path.pop()


    def isValid(self, s,i,j):
        while i<j:
            if s[i]==s[j]:
                i=i+1
                j=j-1
            else:
                return False
        return True


        
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.partition("aab"))