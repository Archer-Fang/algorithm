package PartFourCodeTop.q69Sqrtx;
//Java：x 的平方根
public class q69Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.mySqrt(8);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
       int max=x;
       int min=0;
       while(max-min>1){
           int mid=min+(max-min)/2;
           if(x/mid<mid){
               max=mid;
           }else{
               min=mid;
           }
       }
       return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
