package SlideWindow.q1186;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 20:11
 **/
class Solution {
    public int maximumSum(int[] arr) {
        if(arr.length == 1)return arr[0];
        int[] prefixDp = new int[arr.length]; //正向DP  prefixDp[i]  从 0 到 i元素的 最大子数组和
//        int[] suffixDp = new int[arr.length];   //逆向DP suffixDp[i]  从 arr.len 到 i 的最大子数组和
        prefixDp[0] = arr[0];
//        suffixDp[arr.length-1] = arr[arr.length-1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            prefixDp[i] = Math.max(prefixDp[i-1] + arr[i] , arr[i]);
            max = Math.max(max,prefixDp[i]);
//            suffixDp[arr.length-1-i] = Math.max(suffixDp[arr.length-i] + arr[arr.length-1-i],arr[arr.length-1-i]);
//            max = Math.max(max,prefixDp[i]);
        }
        for(int i=0;i<arr.length;i++){  //删掉下标为i之后的最大值
            int left = i!=0 ? prefixDp[i-1] : 0;
//            int right = i!=arr.length-1 ? suffixDp[i+1] : 0;
//            max = Math.max(max,left+right);
            max = Math.max(max,left);
        }
        return max;
    }

}
public class q1186 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maximumSum(new int[]{1,-2,0,3}));
    }
}
