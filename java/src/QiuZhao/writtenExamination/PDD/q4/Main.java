package QiuZhao.writtenExamination.PDD.q4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/11 18:49
 **/
//1
//3 7
//.*...*.
//***.***
//.*...*.

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=Integer.parseInt(in.nextLine());
        int[] ans = new int[T];
        int k=0;
        while ((T--)>0){
            int N=Integer.parseInt(in.nextLine());
            int c=0;
            int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 1; i < nums.length-1; i++) {
                if(nums[i]==nums[i-1]&&nums[i]==nums[i+1]||nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                    c++;
                }
                hashSet.add(nums[i]);
            }
            boolean flag=true;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i]!=nums[i+1]) flag=false;
            }

            hashSet.add(nums[0]);
            hashSet.add(nums[nums.length-1]);
            if(c==0) c=1;
            if(N==1) ans[k++]=0;
            else if(N==2&&nums[0]==nums[1]) ans[k++]=1;
            else if(N==2&&nums[0]!=nums[1]) ans[k++]=0;
            else if(flag) ans[k++]=nums.length/2;
            else if(N==3&&(nums[0]==nums[1]&&nums[2]==nums[1]||nums[0]!=nums[1]&&nums[2]!=nums[1])) ans[k++]=2;
            else if(N==3) ans[k++]=1;
            else ans[k++]=Math.min(hashSet.size(),c);

        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }



    }



}
