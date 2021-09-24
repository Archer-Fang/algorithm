package PartOneReWrite.Heap.q91DecodeWays;
//Java：解码方法
public class q91DecodeWays{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.numDecodings("12");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        final int length = s.length();
        if(length == 0) return 0;
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[length];
        dp[0] = 1;
        if(length==1) return dp[0];


        //dp[i]=dp[i-1]+dp[i-2]
        for(int i=1;i<length;i++){
            if(s.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }
            if((s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                if(i>1){
                    dp[i] += dp[i-2];
                }else {
                    dp[i]+=1;
                }

            }
        }

        return dp[length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
