package Tree.q55;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 14:41
 **/
class Solution {

    public int maxDepth(TreeNode root) {
        int max=0;
        return maxDepth(root,0);
    }
    public int maxDepth(TreeNode root,int deep) {
        if(root==null){
            return deep;
        }
        int l=maxDepth(root.left,deep+1);
        int r=maxDepth(root.right,deep+1);
        return l>r?l:r;

    }
}

public class q55 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);
//        t1.left=t2;
//        t1.right=t3;
//        t3.left=t4;
//        t3.right=t5;
        System.out.println(solution.maxDepth(t1));
    }
}
