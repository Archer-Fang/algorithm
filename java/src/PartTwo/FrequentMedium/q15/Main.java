package PartTwo.FrequentMedium.q15;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 15:39
 **/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tmp=new LinkedList<>();
        if(nums.length<3) return tmp;
        //两数之和重复两次
        //指针
        Arrays.sort(nums);
        for (int point1=0;point1<nums.length-2&&nums[point1]<=0;point1++){
            if(point1>0&&nums[point1]==nums[point1-1]) continue;
            int point2=point1+1,point3=nums.length-1;
            while (point2<point3){
                if(nums[point1]+nums[point2]+nums[point3]==0){
                    LinkedList l=new LinkedList();
                    l.add(nums[point1]);
                    l.add(nums[point2]);
                    l.add(nums[point3]);
                    tmp.add(l);
                    while (point2 < point3 && nums[point2]==nums[++point2]) ;
                    while (point2 < point3 && nums[point3]==nums[--point3]) ;
                }
                else if(nums[point1]+nums[point2]+nums[point3]>0){
                    point3--;
                }
                else if(nums[point1]+nums[point2]+nums[point3]<0){
                    point2++;
                }
            }

        }

        return new ArrayList<>(tmp) ;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(solution.threeSum(new int[]{0,0,0}));
    }
}
