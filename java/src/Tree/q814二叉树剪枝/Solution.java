package Tree.q814二叉树剪枝;

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        TreeNode virtualNode=new TreeNode(-1);
        virtualNode.left=root;
        dfs(virtualNode);
        return virtualNode.left;

    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        if(l==0) root.left=null;
        if(r==0) root.right=null;
        return root.val+l+r;

    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(0);
        TreeNode t3=new TreeNode(0);
        TreeNode t4=new TreeNode(1);
        t1.right=t2;
        t2.left=t3;
        t2.right=t4;
        Solution solution=new Solution();
        System.out.println(solution.pruneTree(t1));
    }
}
