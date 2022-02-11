# coding=utf-8
from typing import List


# 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
# 
#  数组中的每个元素代表你在该位置可以跳跃的最大长度。 
# 
#  判断你是否能够到达最后一个下标。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [2,3,1,1,4]
# 输出：true
# 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [3,2,1,0,4]
# 输出：false
# 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 3 * 10⁴ 
#  0 <= nums[i] <= 10⁵ 
#  
#  Related Topics 贪心 数组 动态规划 👍 1634 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # dp = [0] * len(nums)
        # dp[0] = 1
        # for i in range(len(nums)):
        #     if dp[i] == 1 and nums[i] > 0:
        #         if nums[i] + i + 1 > len(nums):
        #             dp[i + 1:len(nums)] = [1] * nums[i]
        #         else:
        #             dp[i + 1:nums[i] + i + 1] = [1] * nums[i]
        # return dp[len(nums) - 1] == 1

        # m = 0
        # n = len(nums)
        # for i in range(n):
        #     if m < i:
        #         return False
        #     if m < n - 1:
        #         m = max(m, i + nums[i])
        #     else:
        #         return True
        # return m >= n - 1

        m = 0
        n = len(nums)
        for i in range(n):
            if m < i:
                return False
            m = max(m, i + nums[i])
        return True


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.canJump([2, 3, 1, 1, 4]))
    print(s.canJump([3, 2, 1, 0, 4]))
