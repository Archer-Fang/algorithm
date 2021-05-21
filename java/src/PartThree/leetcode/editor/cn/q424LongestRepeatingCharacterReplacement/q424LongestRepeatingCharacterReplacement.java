package PartThree.leetcode.editor.cn.q424LongestRepeatingCharacterReplacement;
//Java：替换后的最长重复字符

public class q424LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.characterReplacement("AABABBA",1);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length()==1) return 0;
        char[] chars = s.toCharArray();
        int ans=0;


        for (int m = 0; m <26 ; m++) {
            char replaceChar= (char) ('A'+m);
            int l=0;
            int modify=k;
            for (int i = 0; i < chars.length; i++) {
                if(replaceChar!=chars[i]) modify--;
                while (l<=i&&modify<0){
                    if(chars[l++]!=replaceChar) modify++;
                }
                ans=Math.max(ans,i-l+1);
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
