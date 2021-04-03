package PartTwo.qBiTreeSerieal.q449;

import java.util.Arrays;

/**
@author Created by Fangzj
@data 2021/4/3 14:47
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Codec {
    StringBuffer sb=new StringBuffer();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }
    public void dfs(TreeNode root){
        if(root==null) {
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] datas=data.split(",");
        int[] nums=new int[datas.length];
        int i=0;
        for (String tmp:datas){
            nums[i++]=Integer.parseInt(tmp);
        }
        return deserialize(nums,0,nums.length-1);
    }
    public TreeNode deserialize(int[] nums,int left,int right) {
        if(left>right) return null;
        int tmp=nums[left];
        TreeNode root=new TreeNode(tmp);
        int i=left;
        for (i=left+1;i<nums.length;i++){
            if(nums[i]>nums[left]) break;
        }

        root.left=deserialize(nums,left+1,i-1);
        root.right=deserialize(nums,i,right);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:

public class Main {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t2.left=t1;
        t2.right=t3;
        String tree = ser.serialize(t2);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(true);
    }
}
