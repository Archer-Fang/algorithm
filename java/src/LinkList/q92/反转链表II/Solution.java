package LinkList.q92.反转链表II;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode hair=new ListNode(0);
        hair.next=head;
        ListNode pre=hair;
        ListNode start=head;
        ListNode end=head;

        for(int i=1;i<m;i++){
            pre=pre.next;
        }
        start=pre.next;
        end=start;
        for(int i=m;i<n;i++){
            end=end.next;
        }
        ListNode next=end.next;
        end.next=null;
        pre.next=null;

        ListNode cur_p=start;
        ListNode pre_p=null;
        ListNode next_p=null;
        while (cur_p!=null){
            next_p=cur_p.next;
            cur_p.next=pre_p;
            pre_p=cur_p;
            cur_p=next_p;
        }
        pre.next=end;
        start.next=next;
        return hair.next;


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
        head=reverseBetween(head,1,4);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
