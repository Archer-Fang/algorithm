#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
# 
#  
#  请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
#  
# 
#  如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
# 输出：4
# 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
# 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
# n 的值 3 。
#  
# 
#  示例 2： 
# 
#  
# 输入：strs = ["10", "0", "1"], m = 1, n = 1
# 输出：2
# 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= strs.length <= 600 
#  1 <= strs[i].length <= 100 
#  strs[i] 仅由 '0' 和 '1' 组成 
#  1 <= m, n <= 100 
#  
# 
#  Related Topics 数组 字符串 动态规划 👍 1241 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:


        dp=[[0 for j in range(n+1)] for i in range(m+1)]

        for str in strs:
            count_zero, count_one = self.count_zero_and_one(str)
            for i in range(m,count_zero-1,-1):
                for j in range(n,count_one-1,-1):
                    dp[i][j] = max(dp[i][j],dp[i-count_zero][j-count_one]+1)
        return dp[m][n]
    def count_zero_and_one(self,  str):
        count_zero, count_one=0,0
        for item in str:
            if item == '0':
                count_zero += 1
            else:
                count_one += 1
        return count_zero, count_one


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.findMaxForm(strs =["10", "0001", "111001", "1", "0"], m = 5, n = 3))