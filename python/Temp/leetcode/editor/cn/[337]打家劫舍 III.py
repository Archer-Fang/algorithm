#coding=utf-8
from typing import List

# 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。 
# 
#  除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
# 相连的房子在同一天晚上被打劫 ，房屋将自动报警。 
# 
#  给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
# 
#  
# 
#  示例 1: 
# 
#  
# 
#  
# 输入: root = [3,2,3,null,3,null,1]
# 输出: 7 
# 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
# 
#  示例 2: 
# 
#  
# 
#  
# 输入: root = [3,4,5,1,3,null,1]
# 输出: 9
# 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
#  
# 
#  
# 
#  提示： 
# 
#  
# 
#  
#  树的节点数在 [1, 10⁴] 范围内 
#  0 <= Node.val <= 10⁴ 
#  
#  Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1178 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rob(self, root: TreeNode) -> int:
        if root.left==None and root.right==None:
            return root.val
        dp=[0,0]

        def dfs(root,dp):
            if root==None:
                return [0,0]
            l=dfs(root.left,dp)
            r=dfs(root.right,dp)
            cur=[0,0]
            cur[1]=root.val+l[0]+r[0]
            cur[0]=max(l[0],l[1])+max(r[0],r[1])
            return cur
        r=dfs(root,dp)
        return max(r[:])

# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s=Solution()

    print(s.rob(TreeNode(3,
                         TreeNode(2,None,TreeNode(3)),
                         TreeNode(3,None,TreeNode(1)))))