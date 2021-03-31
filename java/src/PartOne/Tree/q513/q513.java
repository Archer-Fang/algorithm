package PartOne.Tree.q513;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 20:05
 **/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> q=new LinkedList<>();
        TreeNode t1=null;
        q.add(root);
        while (q.size()!=0){
            for (int i=0;i<q.size();i++){
                t1=q.remove();
                if(t1.right!=null) q.add(t1.right);
                if(t1.left!=null) q.add(t1.left);
            }
        }
        return t1.val;
    }
}
public class q513 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t2.left=t1;
        t2.right=t3;

        System.out.println(solution.findBottomLeftValue(t2));
    }
}
