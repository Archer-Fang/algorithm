package QiuZhao.writtenExamination.XC.q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 20:16
 **/
public class Main3 {
    public static void main(String[] args) {
        //首先，这个次数最多能有几次。 min+sum-min*num.length
        //最少，则需要数字大的尽可能连在一起。如果不连着一起必定会有惩罚。 min+ds.
        //3 1 2 1 3 0->2 0 1 0 2 0->1 0 0 0 1 0->
        //[0,2,1,1,2.0]
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] nums=new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            nums[i]=arr[i];
        }
        int ans=0;
        int sum=Arrays.stream(nums).sum();
        while (sum!=0){
            int i = 0;
            for (; i < nums.length; i++) {
                if(nums[i]!=0){
                    sum--;
                    nums[i]--;
                }else {
                    ans++;
                    while (i+1<nums.length&&nums[i+1]==0){
                        i++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
