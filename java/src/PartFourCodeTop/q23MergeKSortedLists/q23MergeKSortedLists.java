package PartFourCodeTop.q23MergeKSortedLists;
//Java：合并K个升序链表
public class q23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length ==1) return lists[0];
        int mid=lists.length/2;
        ListNode[] listsA=new ListNode[mid];
        ListNode[] listsB=new ListNode[lists.length-mid];
        for (int i = 0; i < mid; i++) {
            listsA[i]=lists[i];
        }
        for (int i = mid; i < lists.length; i++) {
            listsB[i-mid]=lists[i];
        }
        return mergeTwoLists(mergeKLists(listsA),mergeKLists(listsB));

    }
    public ListNode mergeTwoLists(ListNode listsA,ListNode listsB){
        if(listsA==null) return listsB;
        if(listsB==null) return listsA;
        ListNode dump = new ListNode(0),cur=dump;
        while(listsA!=null && listsB!=null){
            if(listsA.val<listsB.val){
                ListNode tmp=listsA.next;
                listsA.next=cur.next;
                cur.next=listsA;
                listsA=tmp;
                cur=cur.next;
            }else{
                ListNode tmp=listsB.next;
                listsB.next=cur.next;
                cur.next=listsB;
                listsB=tmp;
                cur=cur.next;
            }
        }
        if(listsA!=null){
            cur.next=listsA;
        }
        if(listsB!=null){
            cur.next=listsB;
        }
        return dump.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
