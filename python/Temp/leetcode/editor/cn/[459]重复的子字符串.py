# 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
# 
#  示例 1: 
# 
#  
# 输入: "abab"
# 
# 输出: True
# 
# 解释: 可由子字符串 "ab" 重复两次构成。
#  
# 
#  示例 2: 
# 
#  
# 输入: "aba"
# 
# 输出: False
#  
# 
#  示例 3: 
# 
#  
# 输入: "abcabcabcabc"
# 
# 输出: True
# 
# 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
#  
#  Related Topics 字符串 字符串匹配 👍 586 👎 0

# asdfasdfasdf
# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = list(s)
        n = len(s)
        next = [-1] * n
        j = -1
        for i in range(1, n):
            while j > -1 and s[j + 1] != s[i]:
                j = next[j]
            if s[j + 1] == s[i]:
                j += 1
            next[i] = j
        return n % (n - (next[n - 1] + 1)) == 0 and next[n-1]!=-1


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.repeatedSubstringPattern("abac"))
