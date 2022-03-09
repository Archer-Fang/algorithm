#coding=utf-8
from typing import List

# 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
# 
#  
#  请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
# 
#  如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
#  
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
#  Related Topics 数组 字符串 动态规划 👍 643 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:

        dp=[[0]*(m+1) for _ in range(n+1)]
        for s in strs:
            zero, one = self.get_zero_one_num(s)
            for w1 in range(n,one-1,-1):
                for w2 in range(m, zero - 1, -1):
                    dp[w1][w2]=max(dp[w1][w2],dp[w1-one][w2-zero]+1)
        return dp[n][m]

    def get_zero_one_num(self,str):
        a,b=0,0
        for i in str:
            if i=="0":
                a+=1
            else:
                b+=1
        return a,b
# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s=Solution()
    print(s.findMaxForm(["10", "0001", "111001", "1", "0"], m = 5, n = 3))
    print(s.findMaxForm(["10", "0", "1"], m = 1, n = 1))