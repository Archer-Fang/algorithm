package PartFourCodeTop.q103BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

//Java：二叉树的锯齿形层序遍历
public class q103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int c=0;
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            c++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(c%2==0){
                    list.add(0,poll.val);
                }else {
                    list.add(poll.val);
                }
                list.add(poll.val);
                if(Objects.nonNull(poll.left)){
                    queue.add(poll.left);
                }
                if(Objects.nonNull(poll.right)){
                    queue.add(poll.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
