# 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：head = [1,2,3,4]
# 输出：[2,1,4,3]
#  
# 
#  示例 2： 
# 
#  
# 输入：head = []
# 输出：[]
#  
# 
#  示例 3： 
# 
#  
# 输入：head = [1]
# 输出：[1]
#  
# 
#  
# 
#  提示： 
# 
#  
#  链表中节点的数目在范围 [0, 100] 内 
#  0 <= Node.val <= 100 
#  
#  Related Topics 递归 链表 👍 1174 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy_node = ListNode(0, head)
        cur=dummy_node
        while cur.next != None and cur.next.next != None:
            tmp1 = cur.next
            tmp2 = cur.next.next.next
            cur.next = cur.next.next
            cur.next.next = tmp1
            tmp1.next = tmp2
            cur=cur.next.next
        return dummy_node.next


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, None))))
    s = Solution()
    s.swapPairs(head)
