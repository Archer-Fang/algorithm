#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
# 输出：3
# 解释：长度最长的公共子数组是 [3,2,1] 。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
# 输出：5
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums1.length, nums2.length <= 1000 
#  0 <= nums1[i], nums2[i] <= 100 
#  
# 
#  Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 1188 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        if len(nums1)==0 or len(nums2)==0:
            return 0
        dp=[[0]*(len(nums2)+1) for i in range(len(nums1)+1)]
        r=0
        #
        # for i in range(len(nums1)+1):
        #     if nums1[i-1]==nums2[0]:
        #         dp[i][0]=1
        #         r = max(r, dp[i][0])
        # for j in range(len(nums2)+1):
        #     if nums1[0]==nums2[j-1]:
        #         dp[0][j]=1
        #         r = max(r, dp[0][j])
        for i in range(1,len(nums1)+1):
            for j in range(1,len(nums2)+1):
                if nums1[i-1]==nums2[j-1]:
                    dp[i][j]=dp[i-1][j-1]+1
                    r=max(r,dp[i][j])
        return r


    # def findLength(self, nums1: List[int], nums2: List[int]) -> int:
    #     dp=[[0 for j in range(len(nums2))] for i in range(len(nums1))]
    #     r=0
    #
    #     for i in range(len(nums1)):
    #         if nums1[i]==nums2[0]:
    #             dp[i][0]=1
    #             r = max(r, dp[i][0])
    #     for j in range(len(nums2)):
    #         if nums2[j]==nums1[0]:
    #             dp[0][j]=1
    #             r = max(r,dp[0][j])
    #     for i in range(1,len(nums1)):
    #         for j in range(1,len(nums2)):
    #             if nums1[i]==nums2[j]:
    #                 dp[i][j]=dp[i-1][j-1]+1
    #                 r=max(r,dp[i][j])
    #     return r
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.findLength(nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]))