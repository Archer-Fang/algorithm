package PartThree.Mid.q86;

/**
 * @author Created by Fangzj
 * @data 2021/5/11 10:49
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode l1=new ListNode(0),l2=new ListNode(0),cur=head,cur2=l1,cur3=l2;
        while (cur!=null){
            ListNode tmp=cur.next;
            if(cur.val<x){
                cur.next=cur2.next;
                cur2.next=cur;
                cur2=cur2.next;
            }else {
                cur.next=cur3.next;
                cur3.next=cur;
                cur3=cur3.next;
            }
            cur=tmp;
        }
        cur2.next=l2.next;
        return l1.next;
    }
}
public class Main {

}
