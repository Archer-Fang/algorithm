#coding=utf-8
from typing import List

# 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
# 
#  题目数据保证答案符合 32 位整数范围。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,2,3], target = 4
# 输出：7
# 解释：
# 所有可能的组合为：
# (1, 1, 1, 1)
# (1, 1, 2)
# (1, 2, 1)
# (1, 3)
# (2, 1, 1)
# (2, 2)
# (3, 1)
# 请注意，顺序不同的序列被视作不同的组合。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [9], target = 3
# 输出：0
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 200 
#  1 <= nums[i] <= 1000 
#  nums 中的所有元素 互不相同 
#  1 <= target <= 1000 
#  
# 
#  
# 
#  进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
#  Related Topics 数组 动态规划 👍 581 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    #回溯超时
    # def combinationSum4(self, nums: List[int], target: int) -> int:
    #     ans = 0
    #     pathes=[]
    #     nums.sort()
    #     def dfs(nums: List[int], target: int,path):
    #         nonlocal ans
    #
    #         if target==0:
    #             ans+=1
    #             pathes.append(path[:])
    #             return
    #         if target<0:
    #             return
    #         for n in nums:
    #             if target-n < 0:
    #                 return
    #             target-=n
    #             path.append(n)
    #             dfs(nums,target,path)
    #             path.pop()
    #             target+=n
    #
    #     dfs(nums, target,[])
    #     return ans

    #dp
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp=[0]*(target+1)
        dp[0]=1
        #dp[i]=sum(dp[i-nums[0]]，dp[i-nums[1]],...,dp[i-nums[n-1]])
        for i in range(0,target+1):
            for j in range(0,len(nums)):
                if i>=nums[j]:
                    dp[i]+=dp[i-nums[j]]
        return dp[target]


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s=Solution()
    print(s.combinationSum4(nums = [1,2,3], target = 4))
    print(s.combinationSum4(nums = [3,1,2,4], target = 4))#8