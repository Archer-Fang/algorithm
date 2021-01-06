package LinkList.q25.K个一组翻转链表.f1;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode(0);
        hair.next=head;
        ListNode tail=hair;
        ListNode pre=hair;
        while(head!=null){
            for(int i=0;i<k;i++){
                if(tail.next==null) return hair.next;
                tail=tail.next;
            }
            ListNode nex=tail.next;
            tail.next=null;
            pre.next=myReverse(head);
            head.next=nex;
            pre=head;
            tail=head;
            head=nex;

        }
        return hair.next;
    }
    // 反转链表
    public static ListNode myReverse(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
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
        head=reverseKGroup(head,2);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
