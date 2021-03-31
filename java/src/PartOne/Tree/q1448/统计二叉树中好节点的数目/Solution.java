package PartOne.Tree.q1448.统计二叉树中好节点的数目;


class Solution {
    int sum=0;
    public int goodNodes(TreeNode root) {
        CountChild(root,root.val);
        return sum;
    }
    public void CountChild(TreeNode root, int max_value){
        if(root==null) return ;
        if(root.val>=max_value){
            max_value=root.val;
            sum++;
        }
        CountChild(root.left,max_value);
        CountChild(root.right,max_value);

    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        Solution solution=new Solution();
        System.out.println(solution.goodNodes(t1));
    }
}
