package PartThree.leetcode.editor.cn.q461HammingDistance;
//Java：汉明距离
public class q461HammingDistance{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        int r=x^y,ans=0;
        while (r!=0){
            ans=(r&1)==1?ans+1:ans;
            r>>=1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
