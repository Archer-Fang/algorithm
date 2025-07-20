#!/usr/bin/env python
#coding=utf-8
from typing import List
# 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: s = "abcabcbb"
# 输出: 3 
# 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
#  
# 
#  示例 2: 
# 
#  
# 输入: s = "bbbbb"
# 输出: 1
# 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
#  
# 
#  示例 3: 
# 
#  
# 输入: s = "pwwkew"
# 输出: 3
# 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
#      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= s.length <= 5 * 10⁴ 
#  s 由英文字母、数字、符号和空格组成 
#  
# 
#  Related Topics 哈希表 字符串 滑动窗口 👍 10432 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)<=1 : return len(s)
        max=0
        for index,item in enumerate(s):
            dic={item:1}
            for j in range(index+1,len(s)):
                if s[j] in dic.keys():
                    max=self.max(max,j-index)
                    break
                else:
                    dic[s[j]]=1
                    max = self.max(max, j+1 - index)
        return max;
    def max(self,i,j):
        if i>j:
            return i
        return j

# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.lengthOfLongestSubstring("bbbbb"))