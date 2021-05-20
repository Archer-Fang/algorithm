package PartThree.Mid.leetcode.editor.cn.q365WaterAndJugProblem;
//Java：水壶问题

public class q365WaterAndJugProblem{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;
        if(jug1Capacity==0||jug2Capacity==0) return targetCapacity==0||jug1Capacity+jug2Capacity==targetCapacity;
        int r=jug1Capacity>jug2Capacity?gbc(jug1Capacity,jug2Capacity):gbc(jug2Capacity,jug1Capacity);
        return targetCapacity%r==0?true:false;
    }

    private int gbc(int a, int b) {
        if(b==0) return a;
        return gbc(b,a%b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
