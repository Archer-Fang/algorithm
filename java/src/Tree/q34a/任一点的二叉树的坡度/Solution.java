package Tree.q34a.任一点的二叉树的坡度;


class Solution {
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
//        return dfs_inner(root)+findTilt(root.left,sum)+findTilt(root.right,sum);
        return computer_sum_d(root)+findTilt(root.left)+findTilt(root.right);
    }
    public int computer_sum_d(TreeNode root) {
        int d=computer_sum(root.left)-computer_sum(root.right);
        d=d>0?d:-d;
        return d;
    }
    public int computer_sum(TreeNode root) {
        if(root==null) return 0;
        int sum=0;
        sum+=root.val;
        sum+=computer_sum(root.left);
        sum+=computer_sum(root.right);
        return sum;
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
        System.out.println(solution.findTilt(t1));
    }
}
