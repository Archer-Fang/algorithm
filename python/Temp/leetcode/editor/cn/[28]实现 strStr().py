# 实现 strStr() 函数。 
# 
#  给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
# 果不存在，则返回 -1 。 
# 
#  
# 
#  说明： 
# 
#  当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
# 
#  对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：haystack = "hello", needle = "ll"
# 输出：2
#  
# 
#  示例 2： 
# 
#  
# 输入：haystack = "aaaaa", needle = "bba"
# 输出：-1
#  
# 
#  示例 3： 
# 
#  
# 输入：haystack = "", needle = ""
# 输出：0
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= haystack.length, needle.length <= 5 * 10⁴ 
#  haystack 和 needle 仅由小写英文字符组成 
#  
#  Related Topics 双指针 字符串 字符串匹配 👍 1179 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(needle) == 0:
            return 0
        # kmp
        # get next
        next = len(needle) * [-1]
        n = len(needle)

        j = -1
        for i in range(1, n):
            while j > -1 and needle[j + 1] != needle[i]:
                j = next[j]
            if needle[j + 1] == needle[i]:
                j += 1
            next[i] = j
        m = len(haystack)
        j = -1
        for i in range(m):
            while j > -1 and haystack[i] != needle[j + 1]:
                j = next[j]
            if (haystack[i] == needle[j + 1]):
                j += 1

            if j + 1 == n:
                return i - n + 1
        return -1


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.strStr("aabaabaafa ", "aabaaf"))
    print(s.strStr("hello ", "ll"))
