package LinkList.q61.旋转链表.f1;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode slow=head;
        int c=0;
        ListNode fast=head;
        ListNode cur=head;
        while (cur!=null){
            c=c+1;
            cur=cur.next;
        }
        k=k%c;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode fast_s=slow.next;
        ListNode slow_s=head;
        slow.next=null;
        fast.next=slow_s;
        return fast_s;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
        ListNode head5=new ListNode(5);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head5.next=null;
        head=rotateRight(head,7);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
