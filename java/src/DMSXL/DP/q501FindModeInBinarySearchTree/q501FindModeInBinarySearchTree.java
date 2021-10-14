package DMSXL.DP.q501FindModeInBinarySearchTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//Java：二叉搜索树中的众数
public class q501FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(2);
        node1.right=node2;
        node2.left=node3;
        solution.findMode(node1);
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
    HashMap<Integer,LinkedList<Integer>> ans=new HashMap<Integer, LinkedList<Integer>>();
    Integer pre;
    int count=0;
    int max=Integer.MIN_VALUE;
    HashSet<Integer> set=new HashSet<Integer>();
    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] r = new int[set.size()];
        int k=0;
        for (Integer integer : set) {
            r[k++]=integer;
        }
        return r;

    }

    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        if(pre!=null&&pre==root.val){
            count++;
            if(count>max){
                set=new HashSet<Integer>();
            }

        }else {
            count=1;
        }
        max=Math.max(max,count);
        if(count==max) set.add(root.val);
        pre=root.val;
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
