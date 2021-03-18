package SlideWindow.q1004;

/**
 * @author Created by Fangzj
 * @data 2021/3/17 20:27
 **/
class Solution {
    public int longestOnes(int[] A, int K) {
        int i=0;
        int ans=0;
        for (int j=0;j<A.length;j++){

            if(A[j]==0) K--;

            while (K<0){

                if(A[i]==0) K++;

                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}

public class q1004 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
}
