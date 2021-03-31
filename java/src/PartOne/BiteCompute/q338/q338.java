package PartOne.BiteCompute.q338;

/**
 * @author Created by Fangzj
 * @data 2021/3/18 20:42
 **/
class Solution {
    public int[] countBits(int num) {
        int[] ans=new int[num+1];
        ans[0]=0;
        for (int i=1;i<num+1;i++){
            if((i&1)>0){
                ans[i]=ans[i-1]+1;
            }
            else {
                ans[i]=ans[i/2];
            }
        }
        return ans;
    }
}
public class q338 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.countBits(2));
    }
}
