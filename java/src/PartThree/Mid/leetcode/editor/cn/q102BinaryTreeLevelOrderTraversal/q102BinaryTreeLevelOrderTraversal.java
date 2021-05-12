package PartThree.Mid.leetcode.editor.cn.q102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层序遍历
public class q102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.levelOrder(null);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int cur=-1;
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int tmp=queue.size();
            for (int i=0;i<tmp;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                list.add(node.val);

            }
            ans.add(list);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
