# 计算给定二叉树的所有左叶子之和。 
# 
#  示例： 
# 
#  
#     3
#    / \
#   9  20
#     /  \
#    15   7
# 
# 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
# 
#  
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 388 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):

    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def dfs(root):
            sum = 0
            if not root:
                return sum
            if root.left and not root.left.left and not root.left.right:
                sum = root.left.val
            sum = sum + dfs(root.left) + dfs(root.right)
            return sum

        return dfs(root)


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    t = TreeNode(0, TreeNode(1), TreeNode(2))
    print(s.sumOfLeftLeaves(t))
