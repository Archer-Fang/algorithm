package DMSXL.DP.q337HouseRobberIii;

//Java：打家劫舍 III
public class q337HouseRobberIii{
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
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return root.val;
        //下标0表示不偷，1表示偷
        int[] ans=dfs(root,new int[]{0,0});
        return Math.max(ans[0],ans[1]);
    }

    private int[] dfs(TreeNode root, int[] ints) {
        if(root==null) return new int[]{0,0};

        int[] l=dfs(root.left,ints);
        int[] r=dfs(root.right,ints);
        int[] cur=new int[2];
        cur[0]=Math.max(l[0],l[1])+Math.max(r[0],r[1]);
        cur[1]=root.val+l[0]+r[0];
        return cur;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
