package Tree.q34e.任一点的求和路径;


class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return dfs_inner(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public int dfs_inner(TreeNode root, int sum) {
        if(root==null) return 0;
        sum-=root.val;
        int count=sum==0?1:0;
        count=count+dfs_inner(root.left,sum);
        count=count+dfs_inner(root.right,sum);
        return count;

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
        System.out.println(solution.pathSum(t1,3));
    }
}
