# 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
# 
#  
#  如果剩余字符少于 k 个，则将剩余字符全部反转。 
#  如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
#  
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：s = "abcdefg", k = 2
# 输出："bacdfeg"
#  
# 
#  示例 2： 
# 
#  
# 输入：s = "abcd", k = 2
# 输出："bacd"
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= s.length <= 10⁴ 
#  s 仅由小写英文组成 
#  1 <= k <= 10⁴ 
#  
#  Related Topics 双指针 字符串 👍 226 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        s = list(s)
        n, start, mid, end = len(s), 0, k - 1, 2 * k - 1
        while start < n:
            if mid < n:
                self.reverse(s, start, mid)
            else:
                self.reverse(s, start, n - 1)
            start, mid, end = end + 1, end + k, end + 2 * k
        return "".join(s)

    def reverse(self, s, l, r):
        while l < r:
            s[l], s[r] = s[r], s[l]
            l += 1
            r -= 1
        return


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    assert s.reverseStr("abcdefg", 2) == "bacdfeg"
    assert s.reverseStr("abcd", 2) == "bacd"
    assert s.reverseStr("abcdefg", 8) == "gfedcba"
