package PartThree.Mid.leetcode.editor.cn.q229MajorityElementIi;
//Java：求众数 II

import java.util.ArrayList;
import java.util.List;

public class q229MajorityElementIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.majorityElement(new int[]{2,1,1,3,1,4,5,6});
        solution.majorityElement(new int[]{1,1,1,3,3,2,2,2});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //(n-1)>n/3 ok
        //(n-1)/2> n/3 ok
        int c1=0,major1=nums[0],marjor2=nums[0],c2=0;
        for (int i = 0; i < nums.length; i++) {
            if(major1==nums[i]) c1++;
            else if(marjor2==nums[i]) c2++;
            else if(c1==0){
                major1=nums[i];
                c1++;
            }else if(c2==0){
                marjor2=nums[i];
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for (int i = 0; i < nums.length; i++) {
            if(major1==nums[i]) c1++;
            if(marjor2==nums[i]) c2++;
        }
        ArrayList<Integer> a = new ArrayList<>();

        if(c1>nums.length/3){
            a.add(major1);
        }
        if(c2>nums.length/3&&major1!=marjor2){
            a.add(marjor2);
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
