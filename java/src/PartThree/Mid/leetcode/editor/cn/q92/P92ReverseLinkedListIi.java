package PartThree.Mid.leetcode.editor.cn.q92;
//Java：反转链表 II
public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        solution.reverseBetween(l1,1,4);
        // TO TEST
    }

}
//leetcode submit region begin(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode slow=head,fast=head,pre=new ListNode(0),next;
        pre.next=head;
        while ((left--)>1){
            slow=slow.next;
            pre=pre.next;
        }
        while ((right--)>1){
            fast=fast.next;
        }
        next=fast.next;
        pre.next=null;
        fast.next=null;

        //头插法
        while (slow!=null){
            ListNode tmp=slow.next;
            slow.next=pre.next;
            pre.next=slow;
            slow=tmp;
        }
        if(pre.val==0){
            head=pre.next;
        }

        while (pre.next!=null){
            pre=pre.next;
        }
        pre.next=next;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)