package DMSXL.DP.q139WordBreak;

import java.util.LinkedList;
import java.util.List;

//Java：单词拆分
public class q139WordBreak{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        LinkedList<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        solution.wordBreak("leetcode",list);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //判定 s中以i结尾 是否可以被空格拆分为一个或多个在字典中出现的单词dp[i]。
        //dp[i+l]=dp[i+l]||(dp[i])&&wordDict.contains(s.subString(i,l)))
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                dp[i]=dp[i]||(wordDict.contains(substring)&&dp[j]);
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
