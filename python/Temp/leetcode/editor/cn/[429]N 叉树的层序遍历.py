# 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
# 
#  树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：root = [1,null,3,2,4,null,5,6]
# 输出：[[1],[3,2,4],[5,6]]
#  
# 
#  示例 2： 
# 
#  
# 
#  
# 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
# null,13,null,null,14]
# 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  树的高度不会超过 1000 
#  树的节点总数在 [0, 10^4] 之间 
#  
#  Related Topics 树 广度优先搜索 👍 192 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


import collections


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        ans = []
        if not root:
            return ans
        queue = collections.deque()
        queue.append(root)
        while len(queue) > 0:
            size = len(queue)
            r = []
            for i in range(size):
                node = queue.popleft()
                r.append(node.val)
                if node.children:
                    for n in node.children:
                        if n:
                            queue.append(n)
            ans.append(r)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()
    t1 = Node(1, [Node(2, None), Node(3, None), Node(4, None)])
    print(s.levelOrder(t1))
