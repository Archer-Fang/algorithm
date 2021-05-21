package PartThree.Mid.q153FindMinimumInRotatedSortedArray;
//Java：寻找旋转排序数组中的最小值

public class q153FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.findMin(new int[]{3,1,2}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    //1 2 3 /3 1 2 /2 3 1
    //1.leftV<midV,midV<rightV return leftV 缩小右边边界
    //2.leftV>midV,midV<rightV 缩小右边边界
    //3.leftV<midV,midV>rightV  缩小左边边界
    //4.leftV>midV,midV>rightV X
    //l<=mid<r
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return nums[l];
//        return nums[l];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
