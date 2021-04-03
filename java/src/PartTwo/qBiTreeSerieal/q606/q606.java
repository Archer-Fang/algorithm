package PartTwo.qBiTreeSerieal.q606;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 21:00
 **/
class Solution {
    StringBuffer sb=new StringBuffer();
    public String tree2str(TreeNode t) {
        dfs(t,sb);
        return sb.toString();
    }
    public void dfs(TreeNode root,StringBuffer ans){
        if(root==null) return ;
        ans.append(root.val);

        if(root.left!=null){
            ans.append("(");
            dfs(root.left,ans);
            ans.append(")");
        }
        if(root.right!=null){
            if(root.left==null){
                ans.append("()");
            }
            ans.append("(");
            dfs(root.right,ans);
            ans.append(")");
        }
        return ;
    }
}
public class q606 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        System.out.println(solution.tree2str(t1));
    }
}
