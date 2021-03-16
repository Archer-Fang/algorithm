package SlideWindow.PreSum.q795;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 16:26
 **/
class Solution {
//    public int numSubarrayBoundedMax(int[] A, int L, int R) {
//        return numSubarrayBoundedMax1(A,R)-numSubarrayBoundedMax2(A,L);
//    }
//    public int numSubarrayBoundedMax1(int[] A, int R) {
//        int pre=0;
//        int ans=0;
//        for (int i=0;i<A.length;i++){
//            if(A[i]<=R) pre++;
//            else pre=0;
//            ans+=pre;
//        }
//        return ans;
//    }
//    public int numSubarrayBoundedMax2(int[] A, int L) {
//        int pre=0;
//        int ans=0;
//        for (int i=0;i<A.length;i++){
//            if(A[i]<L) pre++;
//            else pre=0;
//            ans+=pre;
//        }
//        return ans;
//    }
    //代码写法优化
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A,R)-numSubarrayBoundedMax(A,L-1);
    }
    public int numSubarrayBoundedMax(int[] A, int R) {
        int pre=0;
        int ans=0;
        for (int i=0;i<A.length;i++){
            if(A[i]<=R) pre++;
            else pre=0;
            ans+=pre;
        }
        return ans;
    }

}
public class q795 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numSubarrayBoundedMax(new  int[]{2, 1, 4, 3},2,3));
    }
}


//A = [2, 1, 4, 3]
//L = 2
//R = 3
//输出: 3
//<=R [2],[1],[2,1],[3]
//<L [1]