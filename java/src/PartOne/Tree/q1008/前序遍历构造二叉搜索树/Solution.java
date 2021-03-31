package PartOne.Tree.q1008.前序遍历构造二叉搜索树;


import java.util.LinkedList;
import java.util.Queue;



class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=constructMaximumBinaryTree(preorder,0,preorder.length);
//        System.out.println(walk(root));
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums,int left,int right) {
        if(left==right) return null;
        int root_num=nums[left];
        int index=left;
        int end;
        for(end=left+1;end<right;end++){
            if(nums[end]>root_num) break;
        }
        TreeNode root=new TreeNode(root_num);
        root.left=constructMaximumBinaryTree(nums,index+1,end);
        root.right=constructMaximumBinaryTree(nums,end,right);
        return root;
    }
    String walk(TreeNode root){
        if(root==null) return null;
        StringBuffer sb=new StringBuffer("[");
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode tmq=q.poll();
            if(tmq!=null){
                q.add(tmq.left);
                q.add(tmq.right);
                sb.append(tmq.val+",");

            }
            else {
                sb.append("null,");
            }
        }
        return sb.toString();
    }
}
class Main{
    public static void main(String[] args) {
        int[] pre={8,5,1,7,10,12};
        Solution solution=new Solution();
        System.out.println(solution.bstFromPreorder(pre));
    }
}
