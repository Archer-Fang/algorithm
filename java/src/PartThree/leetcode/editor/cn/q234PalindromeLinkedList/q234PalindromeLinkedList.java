package PartThree.leetcode.editor.cn.q234PalindromeLinkedList;
//Java：回文链表
public class q234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(solution.isPalindrome(node));
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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mock = new ListNode(0);
        while (slow!=null){
            ListNode tmp=slow.next;
            slow.next=mock.next;
            mock.next=slow;
            slow=tmp;
        }
        slow=head;
        fast=mock.next;
        while (fast!=null&&slow.val==fast.val){
            slow=slow.next;
            fast=fast.next;
        }
        return fast!=null?false:true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
