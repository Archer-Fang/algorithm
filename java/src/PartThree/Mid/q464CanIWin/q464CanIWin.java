package PartThree.Mid.q464CanIWin;
//Java：我能赢吗

import java.util.Arrays;
import java.util.HashMap;

public class q464CanIWin{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.canIWin(10,11));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=maxChoosableInteger) return true;
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal) return false;

        //dp+backward
        int[] dp=new int[maxChoosableInteger+1];
        HashMap<String, Boolean> map = new HashMap<>();
        return backward(map,dp,desiredTotal);

    }
    private boolean backward(HashMap<String, Boolean> map, int[] dp, int desiredTotal) {
        String key= Arrays.toString(dp);
        if(map.containsKey(key)) return map.get(key);
        for (int i = 1; i < dp.length; i++) {
            if(dp[i]==0){
                dp[i]=1;
                if(desiredTotal-i<=0||!backward(map,dp,desiredTotal-i)){//如果选i赢了或者选i还没赢，但是第二个人输了
                    map.put(key,true);
                    dp[i]=0;
                    return true;
                }
                dp[i]=0;
            }
        }
        map.put(key,false);
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
