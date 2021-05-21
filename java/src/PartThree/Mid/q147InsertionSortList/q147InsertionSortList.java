package PartThree.Mid.q147InsertionSortList;
//Java：对链表进行插入排序

public class q147InsertionSortList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node4.next=node2;
        node2.next=node1;
        node1.next=node3;
        solution.insertionSortList(node4);
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
    public ListNode insertionSortList(ListNode head) {
        ListNode ans=new ListNode(0),cur=head;
        while (cur!=null){
            ListNode tmp=cur.next;
            ListNode cur2=ans.next,pre=ans;
            while (cur2!=null&&cur2.val<cur.val){
                pre=pre.next;
                cur2=cur2.next;
            }
            cur.next=cur2;
            pre.next=cur;
            cur=tmp;
        }
        return ans.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
