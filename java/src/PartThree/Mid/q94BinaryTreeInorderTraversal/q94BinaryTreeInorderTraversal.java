package PartThree.Mid.q94BinaryTreeInorderTraversal;

import java.util.LinkedList;
import java.util.List;

//Java：二叉树的中序遍历
public class q94BinaryTreeInorderTraversal{
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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        dfs(root,linkedList);
        return linkedList;
    }

    private void dfs(TreeNode root, LinkedList<Integer> linkedList) {
        if(root==null)return;
        dfs(root.left,linkedList);
        linkedList.add(root.val);
        dfs(root.right,linkedList);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
