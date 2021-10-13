package DMSXL.DP.q113PathSumIi;

import java.util.LinkedList;
import java.util.List;

//Java：路径总和 II
public class q113PathSumIi{
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root,targetSum,path,ans);
        return ans;

    }
    private void dfs(TreeNode root, int targetSum, LinkedList<Integer> path, List<List<Integer>> ans) {
        if(root==null) return;

        path.add(root.val);
        if(root.val==targetSum&&root.left==null&&root.right==null){
            ans.add(new LinkedList<>(path));
        }
        dfs(root.left,targetSum-root.val,path,ans);
        dfs(root.right,targetSum-root.val,path,ans);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
