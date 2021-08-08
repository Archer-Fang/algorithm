package PartFourCodeTop.q25ReverseNodesInKGroup;
//Java：K 个一组翻转链表
public class q25ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1) return head;
        ListNode cur=head,tmp=new ListNode(-1),tail=tmp;
        while (cur!=null){
            if(judgeLengthWithK(cur,k)){
                int tmpNum=k;
                while ((tmpNum--)>0){
                    ListNode next=cur.next;
                    cur.next=tail.next;
                    tail.next=cur;
                    cur=next;
                }
                while (tail!=null&&tail.next!=null){
                    tail=tail.next;
                }
            }
            else break;
        }
        if(cur!=null){
            while (tail!=null&&tail.next!=null){
                tail=tail.next;
            }
            tail.next=cur;
        }
        return tmp.next;
    }
    public Boolean judgeLengthWithK(ListNode cur,int k) {
        int c=0;
        while (cur!=null){
            c++;
            cur=cur.next;
            if(c>=k) return true;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
