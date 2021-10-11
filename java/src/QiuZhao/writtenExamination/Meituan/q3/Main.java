package QiuZhao.writtenExamination.Meituan.q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/10 9:52
 **/
public class Main {
    public static void main(String[] args) {
        //小美要给n个朋友送礼物，第i个朋友需要送ai个礼物。商店里有m种礼物，第j种礼物的价格为bj。不同的人对的礼物有不同的要求。有的人希望礼物更加贵重，而有的人认为心意到了就行。因此第i位朋友的每种礼物价格均不能低于ci 。
        //
        //请问给第i位朋友的礼物的最低价格总和为多少？（同一种礼物不能送给同一个人两份，但不同的朋友可以收到相同的礼物）。
        //第一行两个正整数n,m(1≤n,m≤5x104)。
        //
        //第二行n个正整数a1,a2,......,an(1≤ai≤m)。
        //
        //第三行m个正整数b1,b2,.....,bn(1≤bi≤106)。
        //
        //第四行n个正整数c1,c2,....,cn(1≤ci≤106)。
        //
        //数字间两两有空格隔开
        //3 5
        //2 3 3
        //100 200 300 400 500
        //200 300 400
        Scanner in = new Scanner(System.in);
        int[] nm = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int n=nm[0],m=nm[1];
        int[] as = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] bs = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        Arrays.sort(bs);
        int[] cs = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        StringBuffer p = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int sum=0;

            for (int j = 0; j < m; j++) {
                if(bs[j]<cs[i]) continue;
                else {
                    if(as[i]==0) break;
                    sum+=bs[j];
                    as[i]--;
                }
            }
            if(as[i]>0) sum=-1;
            if(i==n-1){
                p.append(sum);
            }else {
                p.append(sum+" ");
            }
        }

        System.out.println(p.toString());


    }
}
