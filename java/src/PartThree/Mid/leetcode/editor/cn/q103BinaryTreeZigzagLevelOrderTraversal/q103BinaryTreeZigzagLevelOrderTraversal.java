package PartThree.Mid.leetcode.editor.cn.q103BinaryTreeZigzagLevelOrderTraversal;


import java.util.*;

//Java：二叉树的锯齿形层序遍历
public class q103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode3.left=treeNode4;
        treeNode3.right=treeNode5;
        solution.zigzagLevelOrder(treeNode1);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int cur=1;
        while (!queue.isEmpty()){
            int tmp=queue.size();
            ArrayList<Integer> list = new ArrayList<>(tmp);

            for (int i=0;i<tmp;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(cur%2==1){
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
            }
            ans.add(list);
            cur++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
