package PartOne.Tree.q662;


import java.util.LinkedList;
import java.util.Queue;
class Result{
    TreeNode node;
    int deep;
    int pos;
    Result(TreeNode node,int deep,int pos){
        this.node=node;
        this.deep=deep;
        this.pos=pos;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getDeep() {
        return deep;
    }

    public int getPos() {
        return pos;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return widthOfBinaryTree( root, 0);

    }
    public int widthOfBinaryTree(TreeNode root,int deep) {
        Queue<Result> q=new LinkedList();
        q.add(new Result(root,0,0));
        int left=0,pos=0,ans=0,curDeep=0;
        while (!q.isEmpty()){
            Result r= q.remove();
            TreeNode h=r.getNode();
            pos=r.getPos();
            deep=r.getDeep();

            if(h!=null){
                q.add(new Result(h.left,deep+1,2*pos+1));
                q.add(new Result(h.right,deep+1,2*pos+2));
                if(curDeep!=deep){
                    curDeep=deep;
                    left=pos;
                }
                ans=ans>(pos-left+1)?ans:(pos-left+1);
            }
        }
        return ans;

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
        System.out.println(solution.widthOfBinaryTree(t1));
    }
}
