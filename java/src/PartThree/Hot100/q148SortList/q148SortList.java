package PartThree.Hot100.q148SortList;

//Java：排序链表
public class q148SortList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        solution.sortList(node1);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast=head.next.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l=mergeSort(slow.next);
        slow.next=null;
        ListNode r=mergeSort(head);
        return merge(l,r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode mock = new ListNode(-1),p=mock;
        while (l!=null&&r!=null){
            if(l.val<r.val){
                p.next=l;
                l=l.next;
            }else {
                p.next=r;
                r=r.next;
            }
            p=p.next;
        }
        p.next=l==null?r:l;
        return mock.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
