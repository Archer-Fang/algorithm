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
#  Related Topics 数组 回溯 👍 924 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        visited=[0]*len(nums)
        ans=[]
        nums=sorted(nums)
        def dfs(nums,visited,path):
            if len(nums)==len(path):
                ans.append(path[:])
                return
            for i in range(len(nums)):
                if i>0 and nums[i]==nums[i-1] and visited[i-1]==0 or visited[i]==1:
                    continue
                visited[i]=1
                path.append(nums[i])
                dfs(nums,visited,path)
                path.pop()
                visited[i]=0
        dfs(nums,visited,[])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
