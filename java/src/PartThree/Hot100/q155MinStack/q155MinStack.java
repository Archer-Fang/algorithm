package PartThree.Hot100.q155MinStack;

import java.util.LinkedList;

//Java：最小栈
public class q155MinStack{
    public static void main(String[] args) {
        MinStack solution = new MinStack();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    LinkedList<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.removeLast();
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for (Integer integer : list) {
            min=Math.min(min,integer);
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
