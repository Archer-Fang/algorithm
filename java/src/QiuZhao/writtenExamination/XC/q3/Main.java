package QiuZhao.writtenExamination.XC.q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 18:56
 **/
//5
//3 1 2 1 3

//6

//6次闪电攻击的目标分别为：
//
//{1}
//
//{1}
//
//{1,2,3,4,5}
//
//{3}
//
//{5}
//
//{5}
public class Main {
    public static void main(String[] args) {

        //首先，这个次数最多能有几次。 min+sum-min*num.length
        //最少，则需要数字大的尽可能连在一起。如果不连着一起必定会有惩罚。 min+ds.
        //3 1 2 1 3
        //[0,2,1,1,2.0]
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] ds=new int[nums.length-1+2];
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min=Math.min(nums[i],min);
        }

        for (int i = 1; i < nums.length; i++) {
            ds[i]=Math.abs(nums[i]-nums[i-1]);
        }
        int ans=min;
        for (int i = 0; i < ds.length-1; i++) {
            if(ds[i]!=ds[i+1]){
                ans+=ds[i];
            }
        }
        System.out.println(ans);




    }
}
