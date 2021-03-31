package PartOne.LinkList.q83.删除排序链表中的重复元素;

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
        ListNode pre=head;
        map_node.put(pre.val,1);
        ListNode cur=head.next;
        while (cur!=null){
            if(map_node.get(cur.val)==null){
                map_node.put(cur.val,1);
                cur=cur.next;
                pre=pre.next;
            }
            else{
                cur=cur.next;
                //删除节点
                pre.next=cur;
            }


        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(1);
        ListNode head3=new ListNode(2);

        head.next=head2;
        head2.next=head3;
        head3.next=null;

        ListNode new_head=deleteDuplicates(head);
        while (new_head!=null){
            System.out.println(new_head.val);
            new_head=new_head.next;
        }
    }
}
