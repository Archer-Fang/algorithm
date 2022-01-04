# 给定一个二叉树，返回它的 后序 遍历。 
# 
#  示例: 
# 
#  输入: [1,null,2,3]  
#    1
#     \
#      2
#     /
#    3 
# 
# 输出: [3,2,1] 
# 
#  进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
#  Related Topics 栈 树 深度优先搜索 二叉树 👍 733 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
#         先序：根-》左-》右 后序：左-》右-》根 逆 根-》右-》左
        r=[]
        stack=[]
        if root!=None:
            stack.append(root)
        while len(stack)>0:
            cur=stack.pop()
            r.append(cur.val)
            if cur.left!=None:
                stack.append(cur.left)
            if cur.right!=None:
                stack.append(cur.right)
        r.reverse()
        return r



# leetcode submit region end(Prohibit modification and deletion)
