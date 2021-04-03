package PartTwo.qbytedance.q36;

import java.util.Stack;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 20:15
 **/
class Solution {
    Stack<Node> stack=new Stack<>();
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        //中序遍历以后是顺序的，以此可以进行相应的操作
        dfs(root);
        Node node = null;
        Node max = null;
        if(!stack.isEmpty()){
            node=stack.pop();
            max=node;
        }
        while (!stack.isEmpty()){
            Node node2=stack.pop();
            node.left=node2;
            node2.right=node;
            node=node2;
        }
        node.left=max;
        max.right=node;
        return node;

    }

    public void dfs(Node root){
        if(root==null) return;
        dfs(root.left);
        stack.add(root);
        dfs(root.right);
        return;
    }
}
public class q36 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        n4.right=n5;
        n4.left=n2;
        n2.left=n1;
        n2.right=n3;
        System.out.println(solution.treeToDoublyList(n4));
    }
}
