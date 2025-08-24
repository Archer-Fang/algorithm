#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,1,2]
# 输出：
# [[1,1,2],
#  [1,2,1],
#  [2,1,1]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 8 
#  -10 <= nums[i] <= 10 
#  
# 
#  Related Topics 数组 回溯 排序 👍 1734 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result=[]
        visit=[0]*len(nums)
        used=[0]*len(nums)
        nums.sort()
        self.backtrack(nums,[],result,visit,used)
        return result

    def backtrack(self, nums, path, result,visit,used):
        if len(path)==len(nums):
            result.append(path[:])
        for i in range(0,len(nums)):
            if visit[i]==1:
                continue
            if i>0 and nums[i]==nums[i-1] and used[i-1]==0:
                continue
            visit[i]=1
            used[i]=1
            path.append(nums[i])
            self.backtrack(nums, path, result, visit, used)
            visit[i]=0
            used[i]=0
            path.pop()



# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s)