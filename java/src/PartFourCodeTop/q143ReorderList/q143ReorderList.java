package PartFourCodeTop.q143ReorderList;
//Java：重排链表
public class q143ReorderList{
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
        solution.reorderList(node1);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return ;
        ListNode slow=head,fast=head,pre=null;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2,cur,cur2;
        if(fast==null){
            head2=reverseList(slow);
            cur=head;
            cur2=head2;
            pre.next=null;
        }else{
            head2=reverseList(slow.next);
            cur=head;
            cur2=head2;
            slow.next=null;
        }

        while(cur!=null&&cur2!=null){
            ListNode tmp = cur2.next;
            cur2.next=cur.next;
            cur.next=cur2;

            cur2=tmp;
            cur=cur.next.next;
        }
        return;

    }
    public ListNode reverseList(ListNode head) {
        ListNode dump = new ListNode(0);
        ListNode cur=head;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next=dump.next;
            dump.next=cur;
            cur=tmp;
        }
        return dump.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
