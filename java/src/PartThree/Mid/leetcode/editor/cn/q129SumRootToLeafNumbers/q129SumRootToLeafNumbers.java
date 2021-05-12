package PartThree.Mid.leetcode.editor.cn.q129SumRootToLeafNumbers;
//Java：求根节点到叶节点数字之和
public class q129SumRootToLeafNumbers{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        int cur=root.val;
        sumNumbers(root,cur);
        return sum;
    }

    private void sumNumbers(TreeNode root, int i) {
        if(root==null) return;
        if(root!=null&&root.left==null&&root.right==null){
            sum+=i;
            return;
        }
        if(root.left!=null){
            sumNumbers(root.left,i*10+root.left.val);
        }
        if(root.right!=null){
            sumNumbers(root.right,i*10+root.right.val);
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
