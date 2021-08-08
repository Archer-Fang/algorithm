package PartThree.leetcode.editor.cn;
//Java：二叉树的序列化与反序列化
public class q297SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        Codec solution = new Codec();
        // TO TEST
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.left=node2;
        node.right=node3;
        solution.deserialize(solution.serialize(null));
        solution.deserialize(solution.serialize(node));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        preDfs(root,buffer);
        midDfs(root,buffer2);
        return buffer.append("aaa").append(buffer2.toString()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("aaa")) return null;
        String[] strings = data.split("aaa");
        String[] preString = strings[0].split(" ");
        String[] midString = strings[1].split(" ");

        String tmp=preString[0];
        TreeNode root = new TreeNode(Integer.parseInt(tmp));
        int l=0;
        for (l = 0; l < midString.length; l++) {
            if(tmp.equals(midString[l])) break;
        }

        root.left=buildTree(preString,1,l,midString,0,l-1);
        root.right=buildTree(preString,l+1,preString.length-1,midString,l+1,midString.length-1);
        return root;
    }

    private TreeNode buildTree(String[] preString, int i, int ii, String[] midString, int i1, int i2) {
        if(i>ii||i1>i2) return null;
        String tmp=preString[i];
        TreeNode root = new TreeNode(Integer.parseInt(tmp));
        int k=0;
        for (k = i1; k <=i2; k++) {
            if(tmp.equals(midString[k])) break;
        }
        int l=k-i1;

        root.left=buildTree(preString,i+1,i+l,midString,i1,k-1);
        root.right=buildTree(preString,i+l+1,ii,midString,k+1,i2);
        return root;
    }

    public void preDfs(TreeNode root,StringBuffer sb) {
        if(root==null) return ;
        sb.append(root.val+" ");
        preDfs(root.left,sb);
        preDfs(root.right,sb);
    }

    public void midDfs(TreeNode root,StringBuffer sb) {
        if(root==null) return ;
        midDfs(root.left,sb);
        sb.append(root.val+" ");
        midDfs(root.right,sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
