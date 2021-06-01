package PartThree.Mid.q611ValidTriangleNumber;
//Java：有效三角形的个数

import java.util.Arrays;

public class q611ValidTriangleNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        //b+c>a a+c>b a+b>c
        //sort-->a+b>c
        //if nums[a]+nums[b]>nums[c]-->(nums[a]+nums[b]>nums[c],...,nums[b-1]+nums[b]>nums[c]) total:b-a
        //else if nums[a]+nums[b]<=nums[c]-->a++
        //double point
        Arrays.sort(nums);
        int ans=0;
        for (int c = nums.length-1; c >1 ; c--) {
            int a=0,b=c-1;
            while (b>a){
                if(nums[a]+nums[b]>nums[c]){
                    ans+=b-a;
                    b--;
                }else {
                    a++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
