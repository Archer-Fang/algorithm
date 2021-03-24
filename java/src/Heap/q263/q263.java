package Heap.q263;

/**
 * @author Created by Fangzj
 * @data 2021/3/22 20:35
 **/
class Solution {
    public boolean isUgly(int n) {
        while (n!=1){
            if(n%2==0) {n/=2;continue;}
            if(n%3==0) {n/=3;continue;}
            if(n%5==0) {n/=5;continue;}
            return false;
        }
        return true;
    }
}
public class q263 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isUgly(6));
    }
}
