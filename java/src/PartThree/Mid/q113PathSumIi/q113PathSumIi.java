package PartThree.Mid.q113PathSumIi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：路径总和 II
public class q113PathSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        solution.pathSum(treeNode1,3);
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> paths=new LinkedList<>();
        List<Integer> path=new LinkedList<>();
        pathSum(root,targetSum,paths,path);
        return paths;
    }
    public void pathSum(TreeNode root, int targetSum,List<List<Integer>> paths,List<Integer> path) {
        if(root==null) return;
        path.add(root.val);
        targetSum-=root.val;
        if(root.right==null&&root.left==null&&targetSum==0){
            paths.add(new LinkedList<>(path));
        }
        pathSum(root.left,targetSum,paths,path);
//        path.remove(path.size()-1);
//        path.add(root.val);
        pathSum(root.right,targetSum,paths,path);
        path.remove(path.size()-1);
        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
