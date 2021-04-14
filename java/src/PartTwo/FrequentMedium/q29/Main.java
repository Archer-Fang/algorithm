package PartTwo.FrequentMedium.q29;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 18:59
 **/
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int sign=1;
        if(dividend>0&&divisor<0||dividend<0&&divisor>0){
            sign=-1;
        }
        long a=dividend;
        long b=divisor;
        a=a>0?a:-a;
        b=b>0?b:-b;
        long res=dfs(a,b);
        if(sign>0) return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)res;
        return (int) -res;
    }
    public long dfs(long a,long b){
        if(a<b) return 0;
        long sum=b;
        long count=1;
        while (sum<=a){
            sum<<=1;
            count<<=1;
        }
        sum>>>=1;
        count>>>=1;
        return count+dfs(a-sum,b);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.divide(10,3));
    }
}
