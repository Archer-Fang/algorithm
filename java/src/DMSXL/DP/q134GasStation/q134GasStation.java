package DMSXL.DP.q134GasStation;
//Java：加油站
public class q134GasStation{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int n=gas.length;
        int sum=0,rest=0;

        for (int i = 0; i < n; i++) {
            sum+=gas[i]-cost[i];
            rest+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }

        return rest<0?-1:start;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
