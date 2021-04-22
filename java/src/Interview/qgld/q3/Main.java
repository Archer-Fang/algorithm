package Interview.qgld.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/21 19:56
 **/

import java.util.*;

class Solution {
    public void needNum(int n, int k, int[] nums) {
        if(nums.length<=3){
            if(nums.length==1) {
                System.out.println(nums[0]-k);
            }
            if(nums.length==2) {
                System.out.println(nums[0]+nums[1]-k);
            }
            else {
                int[] max={nums[0]+nums[1],nums[2]+nums[1]};
                for (int m=0;m<k;m++){
                    max[0]--;
                    max[1]--;
                }

                System.out.println(Arrays.stream(max).max().getAsInt());
            }

        }
        if(nums.length>3){
            int[] sum=new int[nums.length-1];
            for (int i=0;i<nums.length-1;i++){
                sum[i]=nums[i]+nums[i+1];
            }
            for (int m=0;m<k;m++){
                int maxNum=Integer.MIN_VALUE,cur=0;
                for (int i=0;i<sum.length;i++){
                    if(sum[i]>maxNum){
                        cur=i;
                        maxNum=sum[i];
                    }
                }
                if(sum[0]>=maxNum){
                    sum[0]--;
                    sum[1]--;
                }
                else if(sum[sum.length-1]>=maxNum){
                    sum[sum.length-1]--;
                    sum[sum.length-2]--;
                }
                else {
                    sum[cur]--;
                    if(sum[cur-1]>sum[cur+1]){
                        sum[cur-1]--;
                    }
                    else sum[cur+1]--;
                }
            }
            System.out.println(Arrays.stream(sum).max().getAsInt());
        }


    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);

        int[] d = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution.needNum(d[0], d[1], d1);

    }
}
//3 1
//2 2 2