package Tree.q116.填充每个节点的下一个右侧节点指针;

import java.util.LinkedList;


class Solution {
    public Node connect(Node root) {
        if(root==null) {
            return root;
        }
        LinkedList<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            Node cur=q.peek();
            for(int i=1;i<size;i++){
                cur.next=q.get(i);
                cur=q.get(i);
            }
            for(int i=0;i<size;i++){
                Node cur2=q.remove();
                if(cur2.left!=null){
                    q.add(cur2.left);
                }
                if(cur2.right!=null){
                    q.add(cur2.right);
                }
            }


        }
        return root;

    }
}

class Main{
    public static void main(String[] args) {
        Node t1=new Node(1);
        Node t2=new Node(2);
        Node t3=new Node(3);
        Node t4=new Node(4);
        Node t5=new Node(5);
        Node t6=new Node(6);
        Node t7=new Node(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;

        Solution solution=new Solution();
        System.out.println(solution.connect(t1));
    }
}
