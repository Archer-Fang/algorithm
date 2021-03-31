package PartOne.Tree.q971;

import java.util.LinkedList;
import java.util.List;
class Solution {
    LinkedList<Integer> ans=new LinkedList<>();
    int i=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(!judge(root,voyage)){
            LinkedList<Integer> ans2=new LinkedList<>();
            ans2.add(-1);
            return ans2;
        }
        return ans;
    }

    public Boolean judge(TreeNode root, int[] voyage) {
        if(root==null) return true;
        if(root.val!=voyage[i++]) return false;
        if(root.left!=null&&root.left.val!=voyage[i]){
            TreeNode tmp=root.left;
            root.left=root.right;
            root.right=tmp;
            ans.add(root.val);
        }
        return judge(root.left,voyage)&judge(root.right,voyage);
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t2.left=t3;
        int[] voyage={1,3,2};
        Solution solution=new Solution();
        System.out.println(solution.flipMatchVoyage(t1,voyage));
    }
}
