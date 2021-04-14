package PartTwo.FrequentMedium.q24;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 18:27
 **/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast=head.next;
        ListNode r=new ListNode(0),cur3=r;
        ListNode tmp1,tmp2;
        while (fast!=null){
            if(fast.next!=null){
                tmp1=fast.next.next;
                tmp2=slow.next.next;
            }else {
                tmp1=tmp2=null;
            }

            fast.next=cur3.next;
            cur3.next=fast;
            slow.next=cur3.next.next;
            cur3.next.next=slow;
            cur3=slow;
            fast=tmp1;
            slow=tmp2;
        }
        if(slow!=null){
            slow.next=cur3.next;
            cur3.next=slow;
        }
        return r.next;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
//        l3.next=l4;
        System.out.println(solution.swapPairs(l1));
    }
}
