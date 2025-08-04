#!/usr/bin/env python
#coding=utf-8
import collections
from typing import List, Optional


# 给定二叉树的根节点 root ，返回所有左叶子之和。
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入: root = [3,9,20,null,null,15,7] 
# 输出: 24 
# 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
#  
# 
#  示例 2: 
# 
#  
# 输入: root = [1]
# 输出: 0
#  
# 
#  
# 
#  提示: 
# 
#  
#  节点数在 [1, 1000] 范围内 
#  -1000 <= Node.val <= 1000 
#  
# 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 776 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        q=collections.deque([root])
        result=0
        while q:
            for i in range(len(q)):
                cur = q.popleft()
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
                if  cur.left and not cur.left.right and not cur.left.left:
                    result+=cur.left.val
        return result

# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    t2=TreeNode(20,TreeNode(15),TreeNode(7))
    # generate mock data
    t1=TreeNode(3,TreeNode(9),t2)
    print(s.sumOfLeftLeaves(t2))