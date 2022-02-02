from typing import List


# 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
# 
#  
#  选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
#  
# 
#  重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
# 
#  以这种方式修改数组后，返回数组 可能的最大和 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [4,2,3], k = 1
# 输出：5
# 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [3,-1,0,2], k = 3
# 输出：6
# 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
#  
# 
#  示例 3： 
# 
#  
# 输入：nums = [2,-3,-1,5,-4], k = 2
# 输出：13
# 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 10⁴ 
#  -100 <= nums[i] <= 100 
#  1 <= k <= 10⁴ 
#  
#  Related Topics 贪心 数组 排序 👍 208 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = 0
        i, j = 0, len(nums) - 1
        while i < j:
            if abs(nums[i]) > abs(nums[j]):
                if nums[i] < 0 and k > 0:
                    ans -= nums[i]
                    k -= 1
                else:
                    ans += nums[i]
                i += 1
            else:
                if nums[j] < 0 and k > 0:
                    ans -= nums[j]
                    k -= 1
                else:
                    ans += nums[j]
                j -= 1
        if k % 2 == 0:
            ans += nums[i]
        else:
            ans -= nums[i]
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.largestSumAfterKNegations([-8, 3, -5, -3, -5, -2], 6))
    print(s.largestSumAfterKNegations([3, -1, 0, 2], 3))
