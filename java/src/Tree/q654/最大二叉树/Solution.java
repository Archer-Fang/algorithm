package Tree.q654.最大二叉树;


import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root=constructMaximumBinaryTree(nums,0,nums.length);
        System.out.println(walk(root));
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums,int left,int right) {
        if(left==right) return null;
        int max=nums[left];
        int index=left;
        for(int i=left;i<right;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=constructMaximumBinaryTree(nums,left,index);
        root.right=constructMaximumBinaryTree(nums,index+1,right);
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
        int[] nums= {3,2,1,6,0,5};
        Solution solution=new Solution();
        System.out.println(solution.constructMaximumBinaryTree(nums));
    }
}
