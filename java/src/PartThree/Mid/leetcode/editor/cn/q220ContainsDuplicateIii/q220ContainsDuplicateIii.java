package PartThree.Mid.leetcode.editor.cn.q220ContainsDuplicateIii;
//Java：存在重复元素 III

import java.util.HashMap;

public class q220ContainsDuplicateIii{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //-4 -3 -2 -1 0 1 2 3 4
        //t=3
        //num[i]/(t+1)
        //(-4) (-3 -2 -1 0 1 2 3) (4)
        //if（num[i]<0） num[i]/(t+1)-1
        //(-4) (-3 -2 -1) ( 0 1 2 3) (4)
        //if（num[i]<0） (num[i]+1)/(t+1)-1
        //else return (num[i]+1)/(t+1)
        //(-4,-3 -2 -1) ( 0 1 2 3) (4)
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Long id=getId(nums,i,t);
            if(map.containsKey(id)) return true;
            if(map.containsKey(id-1)&&Math.abs(nums[i]-map.get(id-1))<=t) return true;
            if(map.containsKey(id+1)&&Math.abs(nums[i]-map.get(id+1))<=t) return true;
            map.put(id,nums[i]);
            if(i>=k){
                map.remove(getId(nums,i-k,t));
            }
        }
        return false;
    }
    public Long getId(int[] num,int i,int t){
        if(num[i]<0){
            Long tmp1=Long.valueOf(num[i])+1;
            Long tmp2=Long.valueOf(t)+1;
            return tmp1/tmp2-1;
        }
        else {
            Long tmp1=Long.valueOf(num[i])+1;
            Long tmp2=Long.valueOf(t)+1;
            return tmp1/tmp2;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
