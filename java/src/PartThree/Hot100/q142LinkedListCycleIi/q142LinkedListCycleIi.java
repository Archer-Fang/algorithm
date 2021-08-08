package PartThree.Hot100.q142LinkedListCycleIi;
//Java：环形链表 II
public class q142LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode detectCycle(ListNode head) {
        //f=2s
        //f=s+nb
        //==>s=nb f=2nb
        //step k=a+nb
        ListNode slow=head,fast=head;
        while (true){
            if(fast==null||fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) break;
        }
        fast=head;
        while (fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
