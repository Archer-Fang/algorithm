package PartOne.LinkList.q234.回文链表;

//
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            ListNode tmp_node=slow.next;
            slow.next=pre;
            pre=slow;
            slow=tmp_node;

        }
        if(fast!=null){
            slow=slow.next;
        }
        while(pre!=null&&slow!=null){
            if(pre.val!=slow.val){
                return false;
            }
            else{
                pre=pre.next;
                fast=fast.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(0);
        ListNode head2=new ListNode(0);
        head.next=head2;
        head2.next=null;
        Boolean tf=isPalindrome(head);
        System.out.println(tf);
    }
}
