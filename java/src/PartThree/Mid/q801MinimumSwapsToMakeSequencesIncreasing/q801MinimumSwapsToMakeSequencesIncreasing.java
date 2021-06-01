package PartThree.Mid.q801MinimumSwapsToMakeSequencesIncreasing;
//Java：使序列递增的最小交换次数

public class q801MinimumSwapsToMakeSequencesIncreasing{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        //对于位置 i ，必定 满足以下两种情况 之一 或 同时满足：
        //    1、A[i] > A[i - 1] && B[i] > B[i - 1]
        //    2、A[i] > B[i - 1] && B[i] > A[i - 1]
        //    第一种情况很好理解
        //    第二种的话，就是如果至少存在 A、B 一边不是严格递增的，这表示需要进行交换，
        //    而能够交换的前提，就是交换后的值必定满足递增，即如果是 A[i] 和 B[i] 交换，那么 B[i] 必须大于 A[i - 1]，同理新的 A[i] > B[i - 1]，才能在交换后递增
        //
        //    (上面我重新看了下，写得不是很清楚，下面列举情况就可以看清楚了)
        //
        //    当只满足 A[i] > A[i - 1] && B[i] > B[i - 1]，那么我们可以有以下选择：
        //        1、i 交换，那么 i - 1 必须交换
        //        2、i 不交换，那么 i - 1 必须不交换
        //    当只满足 A[i] > B[i - 1] && B[i] > A[i - 1]，那么我们可以有以下选择：
        //        1、i 交换，那么 i - 1 必须不交换
        //        2、i 不交换，那么 i - 1 必须交换
        //    当同时满足两个条件，即 A[i] > A[i - 1] && B[i] > B[i - 1]，同时 A[i] > B[i - 1] && B[i] > A[i - 1]，那么我们可以有这么几种情况：
        //        1、 i 交换，那么 i - 1 可以选择交换或不交换，选择最优情况
        //        2、 i 不交换，那么 i - 1 同样可以选择 交换 或 不交换，选择最优情况
        //

        int[][] dp=new int[nums1.length][2];
        int c=0;
        dp[0][0]=0;
        dp[0][1]=1;
        for (int i = 1; i < nums1.length; i++) {
            boolean q1 = nums1[i-1]<nums1[i] && nums2[i-1]<nums2[i];
            boolean q2 = nums1[i-1]<nums2[i] && nums2[i-1]<nums1[i];
            //need to swap
            if(q1 && q2){
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+1;
                dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1]);
            }else if(q1){
                dp[i][1]=dp[i-1][1]+1;
                dp[i][0]=dp[i-1][0];
            }else if(q2){
                dp[i][1]=dp[i-1][0]+1;
                dp[i][0]=dp[i-1][1];
            }
        }
        return Math.min(dp[nums1.length-1][0],dp[nums1.length-1][1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
