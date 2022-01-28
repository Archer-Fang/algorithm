from typing import List


# n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
# 
#  给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
# 
#  
#  
#  每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
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
#  
#  Related Topics 数组 回溯 👍 1160 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        visitedx = [0] * n
        visitedy = [0] * n
        path = [['.'] * n for _ in range(n)]
        ans = []

        # '..Q.', \
        # '.Q..', \
        # '...Q', \
        # 'Q...'

        def dfs(n, visitedx, visitedy, path, deep):
            if deep == n:
                ans.append(["".join(row) for row in path])
                return
            for i in range(n):
                if visitedx[deep] == 1 or visitedy[i] == 1:
                    continue
                iir, jjr = deep, i
                flag = False
                while iir >= 0 and jjr >= 0:
                    if path[iir][jjr] == 'Q':
                        flag = True
                        break
                    iir -= 1
                    jjr -= 1
                iil, jjl = deep, i
                while iil >= 0 and jjl < n:
                    if path[iil][jjl] == 'Q':
                        flag = True
                        break
                    iil -= 1
                    jjl += 1
                if flag:
                    continue
                visitedx[deep] = 1
                visitedy[i] = 1
                path[deep][i] = "Q"
                dfs(n, visitedx, visitedy, path, deep + 1)
                visitedx[deep] = 0
                visitedy[i] = 0
                path[deep][i] = "."

        dfs(n, visitedx, visitedy, path, 0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    print(s.solveNQueens(4))
