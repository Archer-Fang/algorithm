package PartTwo.qbytedanceTwo.q1;

import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public int needNum(int n,int[] nums) {
        Arrays.sort(nums);
        int c=0;
        //找相邻数组的d，如果d<=10,跳过，如果20>=d>10,补充一道题目，如果30>=d>20,补充两题,补充完以后如果不能被整除2%3 (3-num.length%3)
        for (int i=1;i<nums.length;i++){
            if((nums[i]-nums[i-1])>10) c+=(nums[i]-nums[i-1])/10;
        }
        return (nums.length+c)%3==0?c:c+(3-(nums.length+c)%3);
    }
}
public class q1 {
    
    public static void main(String[] args) {
        Solution solution=new Solution();
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] d=new int[n];
        String[] ss=in.nextLine().split(" ");
        for (int i=0;i<ss.length;i++){
            d[i]=Integer.parseInt(ss[i]);
        }
        System.out.println(solution.needNum(n,d));
//        System.out.println(solution.needNum(4,new int[]{20,35,23,40}));
    }
}

