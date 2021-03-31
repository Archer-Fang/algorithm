package PartOne.GCD.q365;

/**
 * @author Created by Fangzj
 * @data 2021/3/19 15:08
 **/
class Solution {
    //a*x+b*y=z  a=-2 b=2
    //3a+5b=4>>>a=(4-5b)/3 是整数
    //x=3 y=5 z=4
    //补充知识，贝祖定理ax+by=z 有解当且仅当 z 是 x, yx,y 的最大公约数的倍数
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        if(x==0||y==0) return z==0||x+y==z;
        return z%gcb(x,y)==0?true:false;
    }
    public int gcb(int a,int b){
        if(b==0) return a;
        return gcb(b,a%b);
    }

}
public class q365 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.canMeasureWater(0,0,0));
    }
}
