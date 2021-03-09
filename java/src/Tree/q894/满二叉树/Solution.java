package Tree.q894.满二叉树;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> lt=new LinkedList<>();
        allPossibleFBT( n, lt);
        return lt;
    }

    public void allPossibleFBT(int n,List<TreeNode> lt) {
        if(n==1){
            lt.add(new TreeNode(0));
            return;
        }
        for(int i=1;i<n-1;i=i+2){
            List<TreeNode> l=new LinkedList<>();
            List<TreeNode> r=new LinkedList<>();
            allPossibleFBT(i,l);
            allPossibleFBT(n-i-1,r);

            for(TreeNode lN:l){
                for (TreeNode rN:r){
                    TreeNode root=new TreeNode(0);
                    root.left=lN;
                    root.right=rN;
                    lt.add(root);

                }
            }
        }

    }

}

class Main{
    public static void main(String[] args) {

        Solution solution=new Solution();
        System.out.println(solution.allPossibleFBT(7));
    }
}
