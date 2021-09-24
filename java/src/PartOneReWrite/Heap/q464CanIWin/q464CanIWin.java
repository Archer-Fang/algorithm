package PartOneReWrite.Heap.q464CanIWin;
//Java：我能赢吗
public class q464CanIWin{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.canIWin(10,11);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum=0;
        for (int i = 0; i < maxChoosableInteger; i++) {
            sum+=i+1;
        }
        if(sum<desiredTotal) return false;
        if(maxChoosableInteger>=desiredTotal) return true;
        return dfs(0L,maxChoosableInteger,desiredTotal);
    }

    private boolean dfs(long used, int maxChoosableInteger, int desiredTotal) {
        for (int i = 1; i <= maxChoosableInteger ; i++) {
            long tmp=1<<i;
            if((used&tmp)==0){
                if(i>=desiredTotal|| !dfs(used|tmp,maxChoosableInteger,desiredTotal-i)){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
