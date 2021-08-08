package PartFourCodeTop.q142LinkedListCycleIi;
//Java：环形链表 II
public class q142LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
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
        //fast=2*slow
        //fast=slow+nb
        //slow=nb fast=2nb
        //step k=a+nb
        ListNode fast=head,slow=head;
        while(true){
            if(fast==null||fast.next==null){return null;}
            if(fast==slow) break;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
