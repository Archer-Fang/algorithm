package ShiXi.tenxun.qtenxun.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 20:04
 **/

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 你需要返回一个指针，指向root，表示删减去若干个点后，剩下的树
     * @param root TreeNode类 指向二叉树的根
     * @return TreeNode类
     */
    public TreeNode solve (TreeNode root) {
        // write code here
        TreeNode tmp=dfs(root);
        return tmp;

    }
    public TreeNode dfs(TreeNode root) {
        if(root==null) return null;
        if(root.left==null&&root.right!=null) {
            root.right=null;
            return root;
        }
        if(root.right==null&&root.left!=null) {
            root.left=null;
            return root;
        }
        root.left=dfs(root.left);
        root.right=dfs(root.right);
        return root;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t4.left=t5;
        System.out.println(solution.solve(t1));
    }
}
