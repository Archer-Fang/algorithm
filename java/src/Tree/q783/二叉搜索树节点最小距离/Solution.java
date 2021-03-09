package Tree.q783.二叉搜索树节点最小距离;

class Solution {
    Integer minNum= Integer.MAX_VALUE;
    Integer pre=null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minNum;
    }
    public void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        if(pre!=null){
            minNum=minNum>Math.abs(root.val-pre)?Math.abs(root.val-pre):minNum;
        }
        pre=root.val;
        dfs(root.right);
    }

}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(6);
        TreeNode t4=new TreeNode(1);
        TreeNode t5=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        Solution solution=new Solution();
        System.out.println(solution.minDiffInBST(t1));
    }
}
