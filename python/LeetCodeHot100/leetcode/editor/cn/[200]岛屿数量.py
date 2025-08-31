#!/usr/bin/env python
#coding=utf-8
import collections
from typing import List

# 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
# 
#  岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
# 
#  此外，你可以假设该网格的四条边均被水包围。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：grid = [
#   ['1','1','1','1','0'],
#   ['1','1','0','1','0'],
#   ['1','1','0','0','0'],
#   ['0','0','0','0','0']
# ]
# 输出：1
#  
# 
#  示例 2： 
# 
#  
# 输入：grid = [
#   ['1','1','0','0','0'],
#   ['1','1','0','0','0'],
#   ['0','0','1','0','0'],
#   ['0','0','0','1','1']
# ]
# 输出：3
#  
# 
#  
# 
#  提示： 
# 
#  
#  m == grid.length 
#  n == grid[i].length 
#  1 <= m, n <= 300 
#  grid[i][j] 的值为 '0' 或 '1' 
#  
# 
#  Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2834 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         result=0
#         col=0
#         row=0
#         for col in range(len(grid)):
#             for row in range(len(grid[0])):
#                 if grid[col][row]=='1':
#                     self.dfs(grid,col,row,result)
#                     result=result+1
#         return result
#
#     def dfs(self, grid, col, row, result):
#         if col==len(grid) or col==-1 or row==-1 or row==len(grid[0]) or grid[col][row]=='0':
#             return
#         grid[col][row] = '0'
#         self.dfs(grid,col+1,row,result)
#         self.dfs(grid,col-1,row,result)
#         self.dfs(grid,col,row+1,result)
#         self.dfs(grid,col,row-1,result)
#
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        result=0
        directions = [(1,0),(-1,0),(0,1),(0,-1)]
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col]=='1':
                    result=result+1
                    q = collections.deque([( row,col)])
                    grid[row][col] = '0'
                    while q:
                        cur_row,cur_col = q.popleft()
                        for direction in directions:
                            next_row,next_col = cur_row + direction[0], cur_col + direction[1]
                            if 0<=next_col<len(grid[0]) and 0<=next_row<len(grid) and grid[next_row][next_col] == '1':
                                q.append((next_row,next_col))
                                grid[next_row][next_col] = '0'


        return result




# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    # 58
    print(s.numIslands([ ['1','1','0','0','0'], ['1','1','0','0','0'], ['0','0','1','0','0'], ['0','0','0','1','1'] ]))