package PartTwo.qbytedance.q36;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 20:15
 **/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};