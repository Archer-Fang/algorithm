# 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
# 
#  假设二叉树中至少有一个节点。 
# 
#  
# 
#  示例 1: 
# 
#  
# 
#  
# 输入: root = [2,1,3]
# 输出: 1
#  
# 
#  示例 2: 
# 
#  
# 
#  
# 输入: [1,2,3,4,null,5,6,null,null,7]
# 输出: 7
#  
# 
#  
# 
#  提示: 
# 
#  
#  二叉树的节点个数的范围是 [1,10⁴] 
#  -2³¹ <= Node.val <= 2³¹ - 1 
#  
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 237 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        from collections import deque
        queue = deque()
        queue.append(root)
        ans = 0
        while queue:
            size = len(queue)

            for i in range(0, size):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

                if i == 0:
                    ans = node.val
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    t = TreeNode(1, TreeNode(2), TreeNode(3))
    print(s.findBottomLeftValue(t))
