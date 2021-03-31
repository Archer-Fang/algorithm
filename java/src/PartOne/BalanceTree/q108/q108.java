package PartOne.BalanceTree.q108;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 14:45
 **/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        TreeNode root=new TreeNode(nums[nums.length/2]);
        root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        root.right=sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return root;
    }
}
public class q108 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode output=solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(output);
    }
}
