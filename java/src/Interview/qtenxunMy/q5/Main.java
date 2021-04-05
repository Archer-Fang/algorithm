package Interview.qtenxunMy.q5;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 21:20
 **/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int needNum(int n, int m,int[] nums) {
        for (Integer num:nums){
            if(num%m==0) return 1;
        }
        int ans=2001;
        Arrays.sort(nums);
        //最大的砝码除以m
        //6 3=2
        //5 3=2
        int k=-1;
        if(nums[nums.length-1]%m==0){
            k=nums[nums.length-1]/m;
        }else {
            k=nums[nums.length-1]/m+1;
        }
        for (int i=1;i<=k;i++){
            int ms=m*i;
            int c=0;
            int j=nums.length-1;
            while (j>-1){
                if(ms>=nums[j]){
                    c++;
                    ms-=nums[j];
                    if(ms==0){
                        ans=Math.min(ans,c);
                        break;
                    }
                    if(ms<0) break;
                    continue;
                }
                j--;
            }
        }
        return ans==2001?-1:ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int T=Integer.parseInt(in.nextLine());
        int k=0;
        while ((T--)>0){
            String[] ss1 = in.nextLine().split(" ");
            int[] d1 = new int[ss1.length];
            for (int i = 0; i < ss1.length; i++) {
                d1[i] = Integer.parseInt(ss1[i]);
            }
            int[] d = new int[d1[0]];
            String[] ss = in.nextLine().split(" ");
            for (int i = 0; i < ss.length; i++) {
                d[i] = Integer.parseInt(ss[i]);
            }
            System.out.println(solution.needNum(d1[0],d1[1],d));
        }

//         2
//         1 3 //2
//         2
//         5 6
//         1 2 3 4 12

//         1
//         5 6
//         1 2 3 4 12
//         System.out.println(solution.needNum(5,6, new int[]{1,2,3,4,12}));
    }
}
