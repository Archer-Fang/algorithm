package QiuZhao.writtenExamination.Meituan.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/10 9:52
 **/
//3 4
//1 2 3
//3 4
//4 4 5
//4 4
//1 2 3 3
public class Main {
    public static void main(String[] args) {
        //在一场持续300分钟的算法竞赛中，小美在75分钟后便没有了提交。而在不久之后的另一场比赛中，小美225分钟后便没有了提交。于是被小团调侃用一场比赛的时间打了两场比赛。
        //
        //       小团打了n场比赛，每场比赛持续时间为m分钟，第i场比赛中，小团ai分钟后便没有了提交。请统计，有多少无序对(i,j)满足ai+aj≤m，以方便小美来调侃小团。
        //第一行两个正整数n,m(1≤n≤5x104，1≤m≤109)。
        //
        //第二行n个正整数a1,a2,......,an（1≤ai≤109）。
        Scanner in = new Scanner(System.in);
        long[] nums2 = Arrays.stream(in.nextLine().split(" ")).mapToLong(num -> Long.parseLong(num)).toArray();
        long n= nums2[0],m= nums2[1];
        long[] nums = Arrays.stream(in.nextLine().split(" ")).mapToLong(num -> Long.parseLong(num)).toArray();
        Arrays.sort(nums);
        int l=0,r=nums.length-1;
        long ans=0;
        while (l<=r){
            if(nums[r]*2<=m) {
                ans++;
                r--;
            }
            else {
                if(nums[r]+nums[l]<=m) {
                    ans++;
                    r--;
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        System.out.println(ans);

    }
}
