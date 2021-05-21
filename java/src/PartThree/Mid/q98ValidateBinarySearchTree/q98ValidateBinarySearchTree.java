package PartThree.Mid.q98ValidateBinarySearchTree;

import java.util.LinkedList;

//Java：验证二叉搜索树
public class q98ValidateBinarySearchTree{
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
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        dfs(root,linkedList);
        return flag;
    }
    private void dfs(TreeNode root, LinkedList<Integer> linkedList) {
        if(root==null) return;
        dfs(root.left,linkedList);
        if(linkedList.size()>0&&root.val<=linkedList.get(linkedList.size()-1)){
            flag=false;
        }
        linkedList.add(root.val);
        dfs(root.right,linkedList);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
