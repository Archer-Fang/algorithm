# 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
# b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
# 
#  
#  0 <= a, b, c, d < n 
#  a、b、c 和 d 互不相同 
#  nums[a] + nums[b] + nums[c] + nums[d] == target 
#  
# 
#  你可以按 任意顺序 返回答案 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,0,-1,0,-2,2], target = 0
# 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [2,2,2,2,2], target = 8
# 输出：[[2,2,2,2]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 200 
#  -10⁹ <= nums[i] <= 10⁹ 
#  -10⁹ <= target <= 10⁹ 
#  
#  Related Topics 数组 双指针 排序 👍 1049 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        ans = []
        n = len(nums)
        for i1 in range(n - 2):

            if i1 > 0 and nums[i1] == nums[i1 - 1]:
                continue
            for i2 in range(i1 + 1, n - 2):
                if i2 > i1 + 1 and nums[i2] == nums[i2 - 1]:
                    continue
                l = i2 + 1
                r = n - 1
                while l < r:
                    if nums[i1] + nums[i2] + nums[l] + nums[r] < target:
                        l += 1
                    elif nums[i1] + nums[i2] + nums[l] + nums[r] > target:
                        r -= 1
                    else:
                        ans.append([nums[i1], nums[i2], nums[l], nums[r]])
                        while l < r and nums[l] == nums[l + 1]:
                            l += 1
                        while l < r and nums[r] == nums[r - 1]:
                            r -= 1
                        l += 1
                        r -= 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.fourSum([1, 0, -1, 0, -2, 2], 0))
    print(s.fourSum([2, 2, 2, 2, 2], 8))
    print(s.fourSum([-2, -1, -1, 1, 1, 2, 2], 0))
