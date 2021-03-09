package Tree.q0406后继者;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Integer pre=null;
    TreeNode target=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        find(root,p);
        return target;
    }

    public void find(TreeNode root, TreeNode p) {
        if(root==null) return ;
        find(root.left, p);
        if(pre!=null&&pre==p.val)  {target=root;}
        pre=root.val;
        find(root.right, p);



    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t2.left=t1;
        t2.right=t3;
        Solution solution=new Solution();
        System.out.println(solution.inorderSuccessor(t2,t1));
    }
}
