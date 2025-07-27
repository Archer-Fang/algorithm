#!/usr/bin/env python
#coding=utf-8
from typing import List

# 给定一个二叉树，判断它是否是 平衡二叉树 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：root = [3,9,20,null,null,15,7]
# 输出：true
#  
# 
#  示例 2： 
#  
#  
# 输入：root = [1,2,2,3,3,null,null,4,4]
# 输出：false
#  
# 
#  示例 3： 
# 
#  
# 输入：root = []
# 输出：true
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中的节点数在范围 [0, 5000] 内 
#  -10⁴ <= Node.val <= 10⁴ 
#  
# 
#  Related Topics 树 深度优先搜索 二叉树 👍 1623 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
    # 递归检查左子树和右子树是否平衡
        left_balanced = self.isBalanced(root.left)
        right_balanced = self.isBalanced(root.right)
        current_balanced = abs(self.get_height(root.left) - self.get_height(root.right)) <= 1

        if left_balanced and right_balanced and current_balanced:
                return True
        else:
            return False
    def get_height(self, root: Optional[TreeNode]):
        if not root:
            return 0
        return max(self.get_height(root.left),self.get_height(root.right))+1
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s=Solution()
    print(s)