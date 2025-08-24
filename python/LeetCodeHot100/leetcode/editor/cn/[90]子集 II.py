#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
# 
#  解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
# 
#  
#  
#  
#  
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,2,2]
# 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [0]
# 输出：[[],[0]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 10 
#  -10 <= nums[i] <= 10 
#  
# 
#  Related Topics 位运算 数组 回溯 👍 1316 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        result = []
        path = []
        used=[0]*len(nums)
        nums.sort()
        self.backtrack(nums, 0, path, result,used)
        return result

    def backtrack(self, nums, index, path, result,used):
        if index>len(nums):
            return
        result.append(path[:])
        for i in range(index, len(nums)):
            # 如果当前元素与前一个元素相同，并且前一个元素没有被选择（即已经被回溯），则跳过当前元素。这是因为前一个相同的元素已经生成了所有可能的子集，再选择当前元素会导致重复。
            if used[i-1]==0 and i > 0 and nums[i] == nums[i - 1] :
                continue
            used[i]=1
            path.append(nums[i])
            self.backtrack(nums, i + 1, path, result,used)
            path.pop()
            used[i] = 0
    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.subsetsWithDup([1,2,2]))