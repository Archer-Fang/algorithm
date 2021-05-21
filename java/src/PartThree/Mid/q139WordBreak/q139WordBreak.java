package PartThree.Mid.q139WordBreak;

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
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for (int i = 1; i < s.length()+1; i++) {
            for (String tmp :
                    wordDict) {
                if (i-1 + tmp.length()<=s.length()&&s.substring(i-1, i-1 + tmp.length()).equals(tmp)&&dp[i-1]==1){
                    dp[i+tmp.length()-1]=1;
                }
            }
        }
        return dp[s.length()]==1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
