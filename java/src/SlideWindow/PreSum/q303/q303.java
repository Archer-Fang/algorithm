package SlideWindow.PreSum.q303;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 19:49
 **/
class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum=new int[nums.length+1];
        for (int i=1;i<nums.length+1;i++){
            this.sum[i]=this.sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return this.sum[right+1]-this.sum[left];
    }
}
public class q303 {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int param_1 = obj.sumRange(2,5);
        System.out.println(param_1);
    }
}
