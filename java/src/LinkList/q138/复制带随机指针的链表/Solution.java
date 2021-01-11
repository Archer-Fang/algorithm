package LinkList.q138.复制带随机指针的链表;

import java.util.HashMap;

//
class Solution {
    public static class Node {
        int val;
        Node next;
        Node random;
        Node(int x) {
            val = x;
        }
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node,Node> node_node=new HashMap<>();
        Node cur=head;
        while (cur!=null){
            Node tmp_node=new Node(cur.val);
            node_node.put(cur,tmp_node);
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            Node tmp_node=node_node.get(cur);
            tmp_node.next=node_node.get(cur.next);
            tmp_node.random=node_node.get(cur.random);
            cur=cur.next;
        }
        return node_node.get(head);


    }

    public static void main(String[] args) {
        Node head=new Node(7);
        Node head2=new Node(13);
        Node head3=new Node(11);
        Node head4=new Node(10);
        Node head5=new Node(1);
        head.next=head2;
        head.random=null;

        head2.next=head3;
        head2.random=head;

        head3.next=head4;
        head3.random=head5;

        head4.next=head5;
        head4.random=head3;

        head5.next=null;
        head5.random=head;

        head=copyRandomList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
