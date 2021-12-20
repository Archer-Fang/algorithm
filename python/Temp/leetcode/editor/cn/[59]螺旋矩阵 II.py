# 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：n = 3
# 输出：[[1,2,3],[8,9,4],[7,6,5]]
#  
# 
#  示例 2： 
# 
#  
# 输入：n = 1
# 输出：[[1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 20 
#  
#  Related Topics 数组 矩阵 模拟 👍 548 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        # 遍历几圈？
        # 1->1圈，2->1,3->2,4->2,5->3,6->3
        l, r, up, down = 0, n - 1, 0, n - 1
        k = 0
        ans = [[0] * n for _ in range(n)]
        while l < r and up < down:
            for i in range(l, r):
                k += 1
                ans[up][i] = k
            for i in range(up, down):
                k += 1
                ans[i][r] = k
            for i in range(r, l, -1):
                k += 1
                ans[down][i] = k
            for i in range(down, up, -1):
                k += 1
                ans[i][l] = k
            l, r, up, down = l + 1, r - 1, up + 1, down - 1
        if n % 2:
            ans[n // 2][n // 2] = k + 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.generateMatrix(3))
