package DMSXL.DP.q589NAryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

//Java：N 叉树的前序遍历
public class q589NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(Node root, LinkedList<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        for (Node child : root.children) {
            preOrder(child,list);
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
