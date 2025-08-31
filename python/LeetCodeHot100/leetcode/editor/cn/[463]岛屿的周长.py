#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
# 
#  网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
# 
#  岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
# 的周长。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
# 输出：16
# 解释：它的周长是上面图片中的 16 个黄色的边 
# 
#  示例 2： 
# 
#  
# 输入：grid = [[1]]
# 输出：4
#  
# 
#  示例 3： 
# 
#  
# 输入：grid = [[1,0]]
# 输出：4
#  
# 
#  
# 
#  提示： 
# 
#  
#  row == grid.length 
#  col == grid[i].length 
#  1 <= row, col <= 100 
#  grid[i][j] 为 0 或 1 
#  
# 
#  Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 827 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        result=0
        visit=[[0 for j in range(len(grid[0]))] for i in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1 and visit[i][j]==0:
                    result=self.dfs(grid,i,j,visit)
        return result

    def dfs(self, grid, row_index, col_index,visit):
        if not (0<=row_index<len(grid) and 0<=col_index<len(grid[0])):
            return 1
        if grid[row_index][col_index]==0:
            return 1
        if visit[row_index][col_index]==1 :
            return 0
        visit[row_index][col_index]=1
        directions=[(1,0),(-1,0),(0,1),(0,-1)]
        sum=0
        for dr,dc in directions:
            next_row=dr+row_index
            next_col=dc+col_index
            sum+=self.dfs(grid,next_row,next_col,visit)
        return sum




# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.islandPerimeter([[1,0]]))