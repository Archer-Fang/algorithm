package ShiXi.tenxun.qtenxun.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 20:30
 **/

import java.util.Arrays;

//https://www.jianshu.com/p/84608db757b4
class Solution {
    public int needNum(int n, int[] nums) {
        //如果没人
        if (n == 0) return 0;
        //如果一个人
        if (n == 1) return nums[0];
        //如果两个人
        if (n == 2) return Math.max(nums[0], nums[1]);
        //如果三个人，则时间为a+b+c
        if (n == 3) return Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int i=n-1;
        int a=nums[0];
        int b=nums[1];
        int sum=0;
        for (;i>2;i-=2){
            //一共两种方案:
            // 1.最快的两个送最慢的两个。b+a+d+b=a+b+b+d
            // 2.最快的一个送最慢的两个。d+a+c+a=a+a+c+d
            int first=a+b+b+nums[i];
            int second=a+a+nums[i-1]+nums[i];
            if(first<second) sum+=first;
            else sum+=second;
        }
        if(i==2) sum+=a+b+nums[2];
        if (i == 1) sum+=b;
        return sum;
    }

}

public class Main {
    public static void main(String[] args) {
        //         2
        //         3
        //         3 6 9
        //         4
        //         10 1 5 2
        Solution solution = new Solution();

        System.out.println(solution.needNum(4,new int[]{1,2,5,8}));//15
        System.out.println(solution.needNum(4,new int[]{1,8,9,10}));//29


    }
}
