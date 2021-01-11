package LinkList.q21.合并两个有序链表;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode new_head=new ListNode('0');
        new_head.next=null;
        ListNode cur=new_head;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                ListNode tmp_next=l1.next;
                l1.next=null;
                cur.next=l1;
                l1=tmp_next;
                cur=cur.next;
            }
            else{
                ListNode tmp_next=l2.next;
                l2.next=null;
                cur.next=l2;
                l2=tmp_next;
                cur=cur.next;
            }
        }
        if(l1!=null){
            cur.next=l1;
        }
        else {
            cur.next=l2;
        }
        return new_head.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(4);
        ListNode head4=new ListNode(1);
        ListNode head5=new ListNode(3);
        ListNode head6=new ListNode(4);
        head.next=head2;
        head2.next=head3;
        head3.next=null;
        head4.next=head5;
        head5.next=head6;
        head6.next=null;
        ListNode new_head=mergeTwoLists(head,head4);
        while (new_head!=null){
            System.out.println(new_head.val);
            new_head=new_head.next;
        }
    }
}
