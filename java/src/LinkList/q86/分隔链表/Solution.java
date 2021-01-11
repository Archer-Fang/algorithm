package LinkList.q86.分隔链表;

import java.util.HashMap;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode partition(ListNode head,int x) {
        ListNode head1=new ListNode('0');
        ListNode head2=new ListNode('0');
        head1.next=null;
        head2.next=null;
        ListNode cur=head;
        ListNode cur1=head1;
        ListNode cur2=head2;
        while (cur!=null){
            ListNode tmp=cur.next;
            if(cur.val>=x){
                cur.next=null;
                cur2.next=cur;
                cur2=cur2.next;
            }
            else{
                cur.next=null;
                cur1.next=cur;
                cur1=cur1.next;
            }
            cur=tmp;

        }
        cur1.next=head2.next;
        return head1.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(4);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(2);
        ListNode head5=new ListNode(5);
        ListNode head6=new ListNode(2);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head5.next=head6;
        head6.next=null;
        int x=3;
        ListNode new_head=partition(head,x);
        while (new_head!=null){
            System.out.println(new_head.val);
            new_head=new_head.next;
        }
    }
}
