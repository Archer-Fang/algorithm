package PartThree.leetcode.editor.cn.q513FindBottomLeftTreeValue;
//Java：找树左下角的值


import java.util.LinkedList;
import java.util.Queue;

public class q513FindBottomLeftTreeValue{
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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int ans=0;
        while (!queue.isEmpty()){
            int size=queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode tmp=queue.poll();
                if(i==0) ans=tmp.val;
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }

        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
