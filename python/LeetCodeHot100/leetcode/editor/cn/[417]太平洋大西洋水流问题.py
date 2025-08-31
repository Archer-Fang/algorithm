#!/usr/bin/env python
#coding=utf-8
from typing import List

# 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
# 
#  这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
# 单元格 高于海平面的高度 。 
# 
#  岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
# 
#  返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
# 流向大西洋 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
# 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
#  
# 
#  示例 2： 
# 
#  
# 输入: heights = [[2,1],[1,2]]
# 输出: [[0,0],[0,1],[1,0],[1,1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  m == heights.length 
#  n == heights[r].length 
#  1 <= m, n <= 200 
#  0 <= heights[r][c] <= 10⁵ 
#  
# 
#  Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 765 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        result=[]
        visit_pacific=[[False for j in range(len(heights[0]))] for i in range(len(heights))]
        visit_atlantic = [[False for j in range(len(heights[0]))] for i in range(len(heights))]
        # start from pacific (0,0),(0,1)...(0,n),()
        rows,cols=len(heights),len(heights[0])
        for row_index in range(len(heights)):
            self.dfs(heights,visit_pacific,row_index,0)
            self.dfs(heights,visit_atlantic,row_index,cols-1)
        for col_index in range(len(heights[0])):
            self.dfs(heights,visit_pacific,0,col_index)
            self.dfs(heights,visit_atlantic,rows-1,col_index)
        for row_index in range(len(heights)):
            for col_index in range(len(heights[0])):
                if visit_pacific[row_index][col_index] and visit_atlantic[row_index][col_index]:
                    result.append([row_index,col_index])

        return result

    def dfs(self, heights, visited, row_index, col_index):
        if visited[row_index][col_index]:
            return
        visited[row_index][col_index]=True
        directions=[(1,0),(-1,0),(0,1),(0,-1)]
        for dr,dc in directions:
            next_row,next_col= row_index + dr, col_index + dc

            if  0<=next_row<len(heights) and 0<=next_col<len(heights[0]) and heights[next_row][next_col]>=heights[row_index][col_index] and not visited[next_row][next_col]:
                self.dfs(heights,visited,next_row,next_col)




# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))