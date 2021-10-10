package DMSXL.DP.q257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的所有路径
public class q257BinaryTreePaths{
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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String tmp="";
        preOrder(root,tmp);
        return ans;
    }

    private void preOrder(TreeNode root, String tmp) {
        if(root==null) return;
        tmp=tmp+root.val+"->";
        if(root.left==null&&root.right==null){
            String tmp2=tmp.substring(0,tmp.length()-2);
            ans.add(tmp2);
        }
        preOrder(root.left,tmp);
        preOrder(root.right,tmp);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
