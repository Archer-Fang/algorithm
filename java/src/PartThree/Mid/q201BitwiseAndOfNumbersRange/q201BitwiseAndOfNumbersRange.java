package PartThree.Mid.q201BitwiseAndOfNumbersRange;
//Java：数字范围按位与

public class q201BitwiseAndOfNumbersRange{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.rangeBitwiseAnd(5,7));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count=0;
        while (left!=right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left<<count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
