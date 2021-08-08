package PartFourCodeTop.q206ReverseLinkedList;
//Java：反转链表
public class q206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode tmp = new ListNode(0);
        ListNode cur=head,pre=null;
        while (cur!=null){
            pre=cur;
            cur=cur.next;
            pre.next=tmp.next;
            tmp.next=pre;
        }
        return tmp.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
