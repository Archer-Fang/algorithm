#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
# 
#  叶子节点 是指没有子节点的节点。 
# 
#  示例 1： 
#  
#  
# 输入：root = [1,2,3,null,5]
# 输出：["1->2->5","1->3"]
#  
# 
#  示例 2： 
# 
#  
# 输入：root = [1]
# 输出：["1"]
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中节点的数目在范围 [1, 100] 内 
#  -100 <= Node.val <= 100 
#  
# 
#  Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1241 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []
        r=[]
        single_way=[]


        self.dfs_binaryTreePaths(root,single_way,r)
        return r

    def dfs_binaryTreePaths(self, root: Optional[TreeNode],single_way,r) -> List[str]:
        if not root:
            return
        if not root.left and not root.right:
            r.append("->".join(single_way+[str(root.val)]))
            return
        single_way.append(str(root.val))
        if root.left:
            self.dfs_binaryTreePaths(root.left, single_way,r)
        if root.right:
            self.dfs_binaryTreePaths(root.right, single_way,r)
        single_way.pop()

# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s)