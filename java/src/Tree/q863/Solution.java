package Tree.q863;

import java.util.*;

class Solution {

    // 用map记录每个节点的父节点
    private Map<TreeNode, TreeNode> parents = new HashMap<>();

    private Set<TreeNode> used = new HashSet<>();

    private TreeNode targetNode;

    // 找到目标节点后以目标节点为开始位置向三个方向蔓延
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        find(root, null, target);
        List<Integer> res = new LinkedList<>();
        dfs(targetNode, res, K);
        return res;
    }

    private void find(TreeNode root, TreeNode parent, TreeNode target) {
        if (null == root) {
            return;
        }
        if (root.val == target.val) {
            targetNode = root;
        }
        parents.put(root, parent);
        find(root.left, root, target);
        find(root.right, root, target);
    }

    private void dfs(TreeNode root, List<Integer> collector, int distance) {
        if (root != null && !used.contains(root)) {
            // 标记为已访问
            used.add(root);
            if (distance == 0) {
                collector.add(root.val);
                return;
            }
            dfs(root.left, collector, distance - 1);
            dfs(root.right, collector, distance - 1);
            dfs(parents.get(root), collector, distance - 1);
        }
    }
}
class Main{
    public static void main(String[] args) {
        TreeNode t0=new TreeNode(0);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        TreeNode t9=new TreeNode(9);
        t3.left=t5;
        t3.right=t1;
        t5.left=t6;
        t5.right=t2;
        t2.left=t7;
        t2.right=t4;
        t3.right=t1;
        t1.right=t0;
        t1.left=t8;

        Solution solution=new Solution();
        System.out.println(solution.distanceK(t3,t5,2));



    }
}
