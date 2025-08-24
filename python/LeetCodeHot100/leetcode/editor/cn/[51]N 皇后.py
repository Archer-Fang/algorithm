#!/usr/bin/env python
#coding=utf-8
from typing import List

# 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
# 
#  n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
# 
#  给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
# 
#  
#  
#  每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
#  
#  
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：n = 4
# 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
# 解释：如上图所示，4 皇后问题存在两个不同的解法。
#  
# 
#  示例 2： 
# 
#  
# 输入：n = 1
# 输出：[["Q"]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 9 
#  
# 
#  Related Topics 数组 回溯 👍 2330 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result=[]
        map=[["." for i in range(n)] for i in range(n)]
        self.backtrack(map, 0, n, result)
        return result

    def backtrack(self, map, index_i, n, result):
        if index_i==n:
            result.append(["".join(map[i][:]) for i in range(n)] )
            return

        for j in range(n):
            if self.valid_map(map, index_i, j):
                map[index_i][j]='Q'
                self.backtrack(map, index_i + 1, n, result)
                map[index_i][j]='.'


    def valid_map(self, map, index_i, index_j):
        # 列冲突
        for pre_i in range(index_i):
            if map[pre_i][index_j]=='Q':
                return False
        # 行冲突
        for pre_j in range(index_j):
            if map[index_i][pre_j]=='Q':
                return False
        # 左对角线冲突
        for i, j in zip(range(index_i - 1, -1, -1), range(index_j - 1, -1, -1)):
            if map[i][j]=='Q':
                return False
        # 右对角线冲突
        for i, j in zip(range(index_i - 1, -1, -1), range(index_j + 1, len(map))):
            if map[i][j]=='Q':
                return False
        return True

    def valid_all_condition(self, map):
        result=[["".join(map[i][:])] for i in range(len(map))]
        for item in result:
            if 'Q' not in item[0]:
                return False
        return True


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    # print(s.valid_map([['Q...'], ['.Q..'], ['...Q'], ['..Q.']],1,1))
    print(s.solveNQueens(4))