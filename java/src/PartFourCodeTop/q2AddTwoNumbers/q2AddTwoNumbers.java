package PartFourCodeTop.q2AddTwoNumbers;
//Java：两数相加
public class q2AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(7);
        node1.next = node2;

        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(2);
        node4.next=node5;
        solution.addTwoNumbers(node1,node4);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode cur=dump;
        ListNode cur1=l1,cur2=l2;
        int addOne=0;
        while(cur1!=null&&cur2!=null){
            ListNode tmp = new ListNode((cur1.val + cur2.val+addOne)%10);
            if((cur1.val+cur2.val+addOne)>9){
                addOne=1;
            }else{
                addOne=0;
            }
            tmp.next=cur.next;
            cur.next=tmp;

            cur=cur.next;
            cur1=cur1.next;
            cur2=cur2.next;
        }
        while(cur1!=null){
            ListNode tmp = new ListNode((cur1.val +addOne)%10);
            if((cur1.val+addOne)>9){
                addOne=1;
            }else{
                addOne=0;
            }
            tmp.next=cur.next;
            cur.next=tmp;

            cur=cur.next;
            cur1=cur1.next;
        }
        while(cur2!=null){
            ListNode tmp = new ListNode((cur2.val +addOne)%10);
            if((addOne+cur2.val)>9){
                addOne=1;
            }else{
                addOne=0;
            }
            tmp.next=cur.next;
            cur.next=tmp;

            cur=cur.next;
            cur2=cur2.next;
        }
        if(addOne==1){
            ListNode tmp = new ListNode(1);
            tmp.next=cur.next;
            cur.next=tmp;
            cur=cur.next;
        }

        return dump.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
