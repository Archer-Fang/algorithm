package PartThree.Mid.q445AddTwoNumbersIi;
//Java：两数相加 II

import java.util.Stack;

public class q445AddTwoNumbersIi{
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
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        ListNode cur1=l1,cur2=l2;
        while (cur1!=null){
            stack1.add(cur1.val);
            cur1=cur1.next;
        }
        while (cur2!=null){
            stack2.add(cur2.val);
            cur2=cur2.next;
        }
        int tenNum=0;
        int tmp=0;
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            tmp=stack1.pop()+stack2.pop()+tenNum;
            stack.add(tmp%10);
            tenNum=tmp/10;
        }
        while (!stack1.isEmpty()){
            tmp=stack1.pop()+tenNum;
            stack.add(tmp%10);
            tenNum=tmp/10;
        }
        while (!stack2.isEmpty()){
            tmp=stack2.pop()+tenNum;
            stack.add(tmp%10);
            tenNum=tmp/10;
        }

        if(tenNum!=0){
            stack.add(tenNum);
        }
        ListNode head=new ListNode(stack.pop()),cur=head;
        while (!stack.isEmpty()){
            ListNode node=new ListNode(stack.pop());
            node.next=cur.next;
            cur.next=node;
            cur=cur.next;
        }
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
