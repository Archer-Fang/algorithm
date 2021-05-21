package PartThree.Mid.q144BinaryTreePreorderTraversal;
//Java：二叉树的前序遍历

import java.util.LinkedList;
import java.util.List;

public class q144BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root, LinkedList<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
