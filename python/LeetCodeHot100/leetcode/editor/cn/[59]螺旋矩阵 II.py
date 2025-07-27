#!/usr/bin/env python
#coding=utf-8
from typing import List

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
# 
#  Related Topics 数组 矩阵 模拟 👍 1474 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        array=[[0]*n for i in range(n)]
        # 1->0圈+默认值 2->1圈 3->1圈+默认值 4->2圈 5->2圈+默认值
        circle_num=n//2
        l,r,up,down=0,n,0,n
        num=1
        while circle_num>0:
            for i in range(l,r):
                array[up][i]=num
                num=num+1
            for i in range(up+1,down):
                array[i][r-1]=num
                num=num+1
            for i in range(r-2,l,-1):
                array[down-1][i]=num
                num=num+1
            for i in range(down-1,up,-1):
                array[i][l]=num
                num=num+1
            l+=1
            r-=1
            down=down-1
            up=up+1
            circle_num=circle_num-1
        if n%2==1:
            array[n//2][n//2]=num
        return array

# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s.generateMatrix(1))