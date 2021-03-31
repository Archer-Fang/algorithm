package PartOne.LinkList.q143.重排链表;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return  head;
        ListNode cur_fast=head;
        ListNode cur_slow=head;
        //分为两个链表
        while (cur_fast!=null&&cur_fast.next!=null){
            cur_slow=cur_slow.next;
            cur_fast=cur_fast.next.next;
        }
        ListNode head2=cur_slow.next;
        cur_slow.next=null;
        //第二个链表进行反转
        ListNode cur2=head2;
        ListNode pre2=null;
        while (cur2!=null){
            ListNode tmp=cur2.next;
            cur2.next=pre2;
            pre2=cur2;
            cur2=tmp;
        }
        //合并链表
        ListNode cur1=head;
        cur2=pre2;
        ListNode pair=new ListNode(0);
        ListNode cur=pair;
        while (cur1!=null&&cur2!=null){
            ListNode tmp=cur1.next;
            ListNode tmp2=cur2.next;
            cur1.next=null;
            cur.next=cur1;
            cur=cur.next;
            cur2.next=null;
            cur.next=cur2;
            cur1=tmp;
            cur2=tmp2;
            cur=cur.next;
        }
        if(cur1!=null){
            cur.next=cur1;
        }else  if(cur2!=null){
            cur.next=cur2;
        }

        return pair.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
//        ListNode head5=new ListNode(5);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=null;
//        head4.next=head5;
//        head5.next=null;
        head=reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
