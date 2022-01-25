# 根据一棵树的中序遍历与后序遍历构造二叉树。 
# 
#  注意: 
# 你可以假设树中没有重复的元素。 
# 
#  例如，给出 
# 
#  中序遍历 inorder = [9,3,15,20,7]
# 后序遍历 postorder = [9,15,7,20,3] 
# 
#  返回如下的二叉树： 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7
#  
#  Related Topics 树 数组 哈希表 分治 二叉树 👍 657 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # 中序：左根右，后续：左右根
        if not inorder:
            return
        inorder_root_index = inorder.index(postorder[-1])

        return TreeNode(postorder[-1], self.buildTree(inorder[:inorder_root_index], postorder[:inorder_root_index])
                        , self.buildTree(inorder[inorder_root_index + 1:], postorder[inorder_root_index:-1]))


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    ans = s.buildTree([9, 3, 15, 20, 7], [9, 15, 7, 20, 3])
    print()
