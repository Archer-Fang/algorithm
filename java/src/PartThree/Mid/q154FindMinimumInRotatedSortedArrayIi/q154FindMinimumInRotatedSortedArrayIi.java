package PartThree.Mid.q154FindMinimumInRotatedSortedArrayIi;
//Java：寻找旋转排序数组中的最小值 II

public class q154FindMinimumInRotatedSortedArrayIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        //1 2 3 /3 1 2 /2 3 1
        //1.leftV<midV,midV<rightV return leftV 缩小右边边界
        //2.leftV>midV,midV<rightV 缩小右边边界
        //3.leftV<midV,midV>rightV  缩小左边边界
        //4.leftV>midV,midV>rightV X
        //l<=mid<r
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+(r-l)/2;

            if(nums[mid]<nums[r]){
                r=mid;
            }else if(nums[mid]>nums[r]){
                l=mid+1;
            }else {
                r--;
            }
        }
        return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
