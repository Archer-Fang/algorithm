package PartTwo.qIAmYourMotherI.q88;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/4/3 11:34
 **/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length==m) return;
        int i=m-1,j=n-1,k=m+n-1;
        for (;i>-1&&j>-1&&k>-1;){
            if(nums1[i]<=nums2[j]){
                nums1[k--]=nums2[j--];
            }else {
                nums1[k--]=nums1[i--];
            }
        }
        for (;j>-1;){
            nums1[k--]=nums2[j--];
        }
        return;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        solution.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        solution.merge(new int[]{0},0,new int[]{1},1);
    }
}
