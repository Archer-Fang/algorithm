package PartOne.Tree.q37.序列化二叉树;


import java.util.LinkedList;
import java.util.Queue;


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuffer sb=new StringBuffer("[");
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode queueHeadNode= q.remove();
            if(queueHeadNode!=null){
                sb.append(queueHeadNode.val+",");
                q.add(queueHeadNode.left);
                q.add(queueHeadNode.right);
            }
            else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "[]") return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root=new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while (q.size()!=0){
//            if(i>=vals.length) break;
            TreeNode tmp=q.remove();
            if(!vals[i].equals("null")){
                tmp.left=new TreeNode(Integer.parseInt(vals[i]));
                q.add(tmp.left);
            }
            i++;
            if(!vals[i].equals("null")){
                tmp.right=new TreeNode(Integer.parseInt(vals[i]));
                q.add(tmp.right);
            }
            i++;

        }

        return root;
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        Codec codec=new Codec();
        System.out.println(codec.serialize(t1));
        System.out.println(codec.deserialize("[1,2,3,null,null,4,5,null,null,null,null]"));
    }
}
