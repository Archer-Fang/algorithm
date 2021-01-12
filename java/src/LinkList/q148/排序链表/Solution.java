package LinkList.q148.排序链表;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(tmp);
        ListNode pair=new ListNode(0);
        ListNode cur=pair;
        while (left!=null&&right!=null){
            if(left.val<right.val){
                cur.next=left;
                left=left.next;
            }else {
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        cur.next=right==null?left:right;
        return pair.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(1);
        ListNode head4=new ListNode(3);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=null;
        head=sortList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
