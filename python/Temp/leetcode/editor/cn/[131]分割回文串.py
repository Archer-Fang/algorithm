from typing import List


# 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
# 
#  回文串 是正着读和反着读都一样的字符串。 
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
#  Related Topics 字符串 动态规划 回溯 👍 963 👎 0


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []

        def isPalindrome(s):
            return s == s[::-1]

        def dfs(s, index, path):
            if index == len(s):
                ans.append(path[:])
                return
            for i in range(index, len(s)):
                if not isPalindrome(s[index:i + 1]):
                    continue
                path.append(s[index:i + 1])
                dfs(s, i + 1, path)
                path.pop()

        dfs(s, 0, [])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.partition("aab"))
