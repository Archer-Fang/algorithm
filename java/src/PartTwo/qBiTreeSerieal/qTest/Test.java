package PartTwo.qBiTreeSerieal.qTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 20:21
 **/

class Solution{
    public String serialize_bfs(TreeNode root, String str) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node==null){
                    System.out.println(level+":#,");
                }else {
                    System.out.println(level+":"+node.val+",");
                }
                if(node!=null){
                    queue.add(node.left);
                    queue.add(node.right);
                }


            }
            level++;
        }
        return "";
    }

    public String serialize(TreeNode root) {
        return serialize_bfs(root, "");
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        System.out.println(solution.serialize(t1));
    }
}
