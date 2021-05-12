package PartThree.Mid.leetcode.editor.cn.q91;
//Java：解码方法
public class P91DecodeWays{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.numDecodings("12");
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if(s.length()==0||Integer.parseInt(s.substring(0,1))==0) return 0;
        if(s.length()==1) return 1;

        int[] dp=new int[s.length()+1];
        dp[0]=1;
        if(Integer.parseInt(s.substring(0,1))>=1&&Integer.parseInt(s.substring(0,1))<=9){
            dp[1]+=dp[0];
        }

        //dp[1]=1,dp[2]=0,dp[3]=
        //301
        //()
        for (int i=2;i<s.length()+1;i++){
            int two=Integer.parseInt(s.substring(i-2,i));
            int one=Integer.parseInt(s.substring(i-1,i));
            //前面两位能组成10~26;
            if(two>=10&&two<=26){
                dp[i]=dp[i-2];
            }
            //前面两位不能组成10~26;
            if(one>=1&&one<=9) {
                dp[i]+=dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
