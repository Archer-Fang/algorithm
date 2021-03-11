package DP.q139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 11:09
 **/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp=new Boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0]=true;
        //词的长度小于字符串长度 且 词的装完前一个词以后的状态为true
        //进入判断当前词和字符串是否相等,相等则为true
        for (int i=1;i<s.length()+1;i++){
            for(String item:wordDict){
                if(item.length()<=i&&dp[i-item.length()]&&item.equals(s.substring(i-item.length(),i))){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];

    }
}
public class q139 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String s = "leetcode";
        List<String> wordDict =new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak(s,wordDict));
    }
}
