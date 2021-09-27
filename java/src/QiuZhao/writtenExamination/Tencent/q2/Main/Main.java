package QiuZhao.writtenExamination.Tencent.q2.Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/9/26 20:34
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] s = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        while ((s[0]--)>0){
            int n = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray()[0];
            int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
            System.out.println(getMaxScore(nums));
        }

    }
    public static int getMaxScore(int[] arr){
        int[] dp = new int[arr.length];
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            int j=i;
            int cnt = arr[i];
            dp[i]=Math.max(dp[i],arr[i]);
            while (j<arr.length){
                if(j+arr[j]<arr.length){
                    cnt+=arr[j+arr[j]];
                    j+=arr[j];
                }else break;
            }
            max=Math.max(cnt,max);
        }
        return max;

    }
}
