#!/usr/bin/env python
#coding=utf-8
from typing import List, Optional


# 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：root = [4,2,7,1,3,6,9]
# 输出：[4,7,2,9,6,3,1]
#  
# 
#  示例 2： 
# 
#  
# 
#  
# 输入：root = [2,1,3]
# 输出：[2,3,1]
#  
# 
#  示例 3： 
# 
#  
# 输入：root = []
# 输出：[]
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中节点数目范围在 [0, 100] 内 
#  -100 <= Node.val <= 100 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1984 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        root.right, root.left =root.left, root.right
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    # mock data
    root=TreeNode(2)
    root.left=TreeNode(1)
    root.right=TreeNode(3)
    print(s.invertTree(root))