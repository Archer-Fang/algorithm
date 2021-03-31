package PartOne.BalanceTree.q109;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 14:54
 **/
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode fast=head,slow=head,pre=null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        if(slow==fast) return new TreeNode(slow.val);
        TreeNode root=new TreeNode(slow.val);
        pre.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow.next);
        return root;
    }
}
public class q109 {
}
