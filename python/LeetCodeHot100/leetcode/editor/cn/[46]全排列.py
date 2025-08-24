#!/usr/bin/env python
#coding=utf-8
from typing import List

import h5py.h5o


# 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [0,1]
# 输出：[[0,1],[1,0]]
#  
# 
#  示例 3： 
# 
#  
# 输入：nums = [1]
# 输出：[[1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 6 
#  -10 <= nums[i] <= 10 
#  nums 中的所有整数 互不相同 
#  
# 
#  Related Topics 数组 回溯 👍 3165 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result=[]
        visit=[0]*len(nums)
        self.backtrack(nums, [], result, visit)
        return result

    def backtrack(self, nums, path, result, visit):
        if len(path)==len(nums):
            result.append(path[:])
            return
        for i in range(0,len(nums)):
            if visit[i]==1:
                continue
            visit[i]=1
            path.append(nums[i])
            self.backtrack(nums,path,result,visit)
            visit[i] = 0
            path.pop()



# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.permute([1,2,3]))