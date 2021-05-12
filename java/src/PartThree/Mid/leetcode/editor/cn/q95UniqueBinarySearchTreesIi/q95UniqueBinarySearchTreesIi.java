package PartThree.Mid.leetcode.editor.cn.q95UniqueBinarySearchTreesIi;

import java.util.LinkedList;
import java.util.List;

//Java：不同的二叉搜索树 II
public class q95UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.generateTrees(3);
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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    private LinkedList<TreeNode> dfs(int i, int n ) {
        if(i>n) return new LinkedList<>();
        LinkedList<TreeNode> treeNodes=new LinkedList<>();
        for (int j = i; j < n + 1; j++) {
            LinkedList<TreeNode> ls = dfs(i, j - 1);
            LinkedList<TreeNode> rs = dfs(j + 1,n);
            if(ls.size()>0&&rs.size()>0){
                for (TreeNode l:ls
                ) {
                    for (TreeNode r :
                            rs) {
                        TreeNode treeNode = new TreeNode(j);
                        treeNode.right=r;
                        treeNode.left=l;
                        treeNodes.add(treeNode);
                    }
                }
            }
            else if(ls.size()>0){
                for (TreeNode l:ls
                ) {
                    TreeNode treeNode = new TreeNode(j);
                    treeNode.left=l;
                    treeNodes.add(treeNode);
                }
            }
            else if(rs.size()>0){
                for (TreeNode r :
                        rs) {
                    TreeNode treeNode = new TreeNode(j);
                    treeNode.right=r;
                    treeNodes.add(treeNode);
                }
            }else {
                treeNodes.add(new TreeNode(j));
            }
        }
        return treeNodes;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
