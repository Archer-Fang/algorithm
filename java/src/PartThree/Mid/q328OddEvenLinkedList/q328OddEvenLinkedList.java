package PartThree.Mid.q328OddEvenLinkedList;
//Java：奇偶链表

public class q328OddEvenLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        solution.oddEvenList(node1);
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast=head.next;
        ListNode head2=head.next;
        while (fast!=null && fast.next!=null){
            slow.next=slow.next.next;
            fast.next=fast.next.next;
            slow=slow.next;
            fast=fast.next;
        }
        if(fast!=null) fast.next=null;
        slow.next=head2;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
