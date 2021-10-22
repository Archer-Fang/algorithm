package QiuZhao.writtenExamination.HW.q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/20 20:33
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int sum= Arrays.stream(nums).sum();
        if(sum%2==1) {
            System.out.println("-1");
            return;
        }
        int tmp=sum / 2+1;
        int[] dp = new int[tmp];
        dp[tmp-1]=1;
        String ans="";

        for (int i = tmp-1; i >=0 ; i--) {
            for (int j = nums.length-1; j >=0 ; j--) {
                if(i-nums[j]>=0&&dp[i]==1){
                    dp[i-nums[j]]=1;
                }
            }
        }
        if(dp[0]==1){
            System.out.println(tmp-1);


            ans="";
            String ans2="";
            int res=sum / 2;
            for (int i = 0; i < nums.length; i++) {
                if(res-nums[i]>=0&&dp[res-nums[i]]==1){
                    res=res-nums[i];
                    ans+=nums[i]+" ";
                }else {
                    ans2+=nums[i]+" ";
                }
            }
            System.out.println(ans);
            System.out.println(ans2);


        }
        else {
            System.out.println(-1);
        }



    }
}
