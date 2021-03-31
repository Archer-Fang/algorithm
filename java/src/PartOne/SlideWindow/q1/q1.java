package PartOne.SlideWindow.q1;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/3/17 23:00
 **/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        for (Integer num:nums){

            if(map.containsKey(target-num)){
                return new int[]{map.get(target-num),i};
            }
            map.put(num,i);
            i++;
        }
        return new int[]{0};
    }
}
public class q1 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.twoSum(new int[]{2,7,11,15},9));
    }
}
