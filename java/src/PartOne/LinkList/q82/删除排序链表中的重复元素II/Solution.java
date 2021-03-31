package PartOne.LinkList.q82.删除排序链表中的重复元素II;

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
    public static ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map_node = new HashMap();
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur2=head;
        while (cur2!=null){
            Integer freq=map_node.get(cur2.val);
            map_node.put(cur2.val,freq==null?1:freq+1);
            cur2=cur2.next;
        }
        ListNode new_head=new ListNode('0');
        new_head.next=head;
        ListNode pre=new_head;
        ListNode cur=new_head.next;
        while (cur!=null){
            if(map_node.get(cur.val)==1){
                cur=cur.next;
                pre=pre.next;
            }
            else {
                cur=cur.next;
                pre.next=cur;
            }
        }
        return new_head.next;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(1);
        ListNode head3=new ListNode(1);
        ListNode head4=new ListNode(2);
        ListNode head5=new ListNode(3);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head5.next=null;
        ListNode new_head=deleteDuplicates(head);
        while (new_head!=null){
            System.out.println(new_head.val);
            new_head=new_head.next;
        }
    }
}
