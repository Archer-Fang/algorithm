package Tree.q129.求根到叶子节点数字之和;


class Solution {
    int total_sum=0;
    public int sumNumbers(TreeNode root) {
        obtainPaths(root,0);
        return total_sum;
    }
    public void obtainPaths(TreeNode root,int sum) {
        sum+=root.val;
        if(root.right==null&root.left==null){
            total_sum+=sum;
        }
        if(root.left!=null){
            obtainPaths(root.left,sum*10);
        }

        if(root.right!=null){
            obtainPaths(root.right,sum*10);
        }


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
        System.out.println(solution.sumNumbers(t1));
    }
}
