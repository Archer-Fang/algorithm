# 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
# 
#  （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
# 
#  示例 1: 
# 
#  输入: N = 10
# 输出: 9
#  
# 
#  示例 2: 
# 
#  输入: N = 1234
# 输出: 1234
#  
# 
#  示例 3: 
# 
#  输入: N = 332
# 输出: 299
#  
# 
#  说明: N 是在 [0, 10^9] 范围内的一个整数。 
#  Related Topics 贪心 数学 👍 225 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        if self.checkNum(n):
            return n
        ans = list(str(n))
        for i in range(len(ans) - 1, 0, -1):
            if int(ans[i - 1]) > int(ans[i]):
                ans[i - 1] = str(int(ans[i - 1]) - 1)
                ans[i:] = '9' * (len(ans) - i)
        return int("".join(ans))

    def checkNum(self, n):
        pre = 10
        while n != 0:
            cur = n % 10
            if pre < cur:
                return False
            pre = cur
            n = n // 10
        return True


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.monotoneIncreasingDigits((120)))
    print(s.monotoneIncreasingDigits((100)))
    print(s.monotoneIncreasingDigits((101)))
