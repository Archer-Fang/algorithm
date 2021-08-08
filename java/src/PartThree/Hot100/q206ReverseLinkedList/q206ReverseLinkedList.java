package PartThree.Hot100.q206ReverseLinkedList;

//Java：反转链表
public class q206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode cur=head;
        while (cur!=null){
            ListNode tmp=cur.next;
            cur.next=node.next;
            node.next=cur;
            cur=tmp;
        }

        return node.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
