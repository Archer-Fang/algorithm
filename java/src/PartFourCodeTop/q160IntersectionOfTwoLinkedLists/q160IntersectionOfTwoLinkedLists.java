package PartFourCodeTop.q160IntersectionOfTwoLinkedLists;
//Java：相交链表
public class q160IntersectionOfTwoLinkedLists{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;


        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=listNode3;

        solution.getIntersectionNode(listNode1,node1);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //题解：设链表A的长度为a+c，链表B的长度为b+c，a为链表A不公共部分，b为链表B不公共部分，c为链表A、B的公共部分
    //将两个链表连起来，A->B和B->A，长度：a+c+b+c=b+c+a+c，若链表AB相交，则a+c+b与b+c+a就会抵消，它们就会在c处相遇；若不相交，则c为nullptr，则a+b=b+a，它们各自移动到尾部循环结束，即返回nullptr
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
