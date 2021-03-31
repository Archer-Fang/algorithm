package PartOne.DFS.q979;

/**
 * @author Created by Fangzj
 * @data 2021/3/13 21:03
 **/
class Solution {
    int ans = 0;
    public int distributeCoins(TreeNode root) {

        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int L=dfs(root.left);
        int R=dfs(root.right);
        ans+=Math.abs(L)+Math.abs(R);
        return root.val-1+L+R;
    }
}

public class q979 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(0);
        TreeNode t3=new TreeNode(0);
        t1.left=t2;
        t1.right=t3;

        System.out.println(solution.distributeCoins(t1));
    }
}
