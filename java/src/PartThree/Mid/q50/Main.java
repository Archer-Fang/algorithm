package PartThree.Mid.q50;

/**
 * @author Created by Fangzj
 * @data 2021/5/10 19:25
 **/
class Solution {
    public double myPow(double x, int n) {
        //2^10=2^(1*8)*2^(0*4)*2^(1*2)*2^(0*1); 1010

        if(n<0)  {long tmp=n; return 1/myPow2(x,-tmp);}
        else return myPow2(x,n);
    }
    public double myPow2(double x, long n) {
        //2^10=2^(1*8)*2^(0*4)*2^(1*2)*2^(0*1); 1010
        double ans=1;
        while (n!=0){
            if((n&1)==1){
                ans*=x;
            }
            x*=x;
            n>>=1;
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.myPow(1.0,-2147483648));
    }
}
