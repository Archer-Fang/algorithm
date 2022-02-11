# coding=utf-8
from typing import List


# 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
# 
#  数组中的每个元素代表你在该位置可以跳跃的最大长度。 
# 
#  你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
# 
#  假设你总是可以到达数组的最后一个位置。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: nums = [2,3,1,1,4]
# 输出: 2
# 解释: 跳到最后一个位置的最小跳跃数是 2。
#      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
#  
# 
#  示例 2: 
# 
#  
# 输入: nums = [2,3,0,1,4]
# 输出: 2
#  
# 
#  
# 
#  提示: 
# 
#  
#  1 <= nums.length <= 10⁴ 
#  0 <= nums[i] <= 1000 
#  
#  Related Topics 贪心 数组 动态规划 👍 1397 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def jump(self, nums: List[int]) -> int:
        # n = len(nums)
        # dp = [n + 1] * n
        # dp[0] = 0
        # # dp[i+j]=min(dp[i]+1,dp[i+1]+1,...,dp[j+i])
        # for i in range(0, n):
        #     for j in range(1, nums[i] + 1):
        #         if i + j > n - 1:
        #             break
        #         dp[i + j] = min(dp[i + j], dp[i] + 1)
        # return dp[n - 1]
        max_d = 0
        next_d = 0
        n = len(nums)
        ans = 0
        for i in range(n):
            if max_d < i:
                ans += 1
                max_d = next_d
            next_d = max(next_d, i + nums[i])
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.jump([2, 3, 1, 1, 4]))
