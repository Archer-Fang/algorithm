package PartOneReWrite.Heap.q139WordBreak;

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
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        //dp[i]=dp[i-x]==1&&wordDict.contains(s.sub(i-x,i+1));
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                if(!dp[i]){
                    dp[i]=(dp[j]&&wordDict.contains(s.substring(j,i)));
                }

            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
