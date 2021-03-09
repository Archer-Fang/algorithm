package Tree.q1530.好叶子节点对的数量;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public int countPairs(TreeNode root, int distance) {
        if(root==null) return 0;
        List<Integer> lchildDistances = new LinkedList<>();
        if(root.left!=null) getDeepLink(root.left, 1,lchildDistances);
        List<Integer> rchildDistances = new LinkedList<>();
        if(root.right!=null) getDeepLink(root.right, 1,rchildDistances);
        int ans=0;
        for(Integer i:lchildDistances){
            for(Integer j:rchildDistances){
                if(i+j<=distance) ans++;
            }
        }
        ans+=countPairs(root.left, distance);
        ans+=countPairs(root.right,  distance);

        return ans;
    }
    public void getDeepLink(TreeNode root, int deep,List<Integer> list) {
        if(root==null) return;
        if(root.right==null&&root.left==null){
            list.add(deep);
            return;
        }
        getDeepLink(root.left, deep+1,list);
        getDeepLink(root.right, deep+1,list);

    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;

        Solution solution=new Solution();
        System.out.println(solution.countPairs(t1,3));
    }
}
