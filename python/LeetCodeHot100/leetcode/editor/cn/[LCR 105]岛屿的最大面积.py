#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。 
# 
#  一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
# 0（代表水）包围着。 
# 
#  找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1
# ,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0
# ,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
# 输出: 6
# 解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
# 
#  示例 2： 
# 
#  
# 输入: grid = [[0,0,0,0,0,0,0,0]]
# 输出: 0 
# 
#  
# 
#  提示： 
# 
#  
#  m == grid.length 
#  n == grid[i].length 
#  1 <= m, n <= 50 
#  grid[i][j] is either 0 or 1 
#  
# 
#  
# 
#  注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/ 
# 
#  Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 106 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        max_result=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    max_result=max(max_result,self.dfs(grid,i,j,0))
        return max_result

    def dfs(self, grid, row, col, area):
        if not (0<=row<len(grid) and 0<=col<len(grid[0]) and grid[row][col]==1):
            return area
        grid[row][col] = 0
        return 1+self.dfs(grid, row + 1, col, 0)+self.dfs(grid, row - 1, col, 0)+self.dfs(grid, row, col - 1, 0)+self.dfs(grid, row, col + 1, 0)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.maxAreaOfIsland([[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]))