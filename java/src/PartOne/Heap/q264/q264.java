package PartOne.Heap.q264;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 20:39
 **/
class Solution {
//    public int nthUglyNumber(int n) {
//        for (int i=1;i<Integer.MAX_VALUE;i++){
//            if(isUgly(i)) n--;
//            if(n==0) return i;
//        }
//        return 0;
//    }
//    public boolean isUgly(int n) {
//        while (n!=1){
//            if(n%2==0) {n/=2;continue;}
//            if(n%3==0) {n/=3;continue;}
//            if(n%5==0) {n/=5;continue;}
//            return false;
//        }
//        return true;
//    }
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] ans=new int[n];
        ans[0]=1;
        int id1=0;
        int id2=0;
        int id3=0;
        for (int i=1;i<n;i++){
            ans[i]=Math.min(Math.min(2*ans[id1],3*ans[id2]),5*ans[id3]);
            if(ans[i]==2*ans[id1])id1++;
            if(ans[i]==3*ans[id2])id2++;
            if(ans[i]==5*ans[id3])id3++;

        }
        return ans[n-1];
    }
}
public class q264 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.nthUglyNumber(11));
    }
}
