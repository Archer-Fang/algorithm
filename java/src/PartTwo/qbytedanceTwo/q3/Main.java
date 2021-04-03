package PartTwo.qbytedanceTwo.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/2 15:16
 **/


import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int solve(int n, int m) {
        int pre=1;
        while (m!=0){
            int count=getCntOfPre(pre,n);//3
            if(m>count){//不在以1为前缀的范围里
                m-=count;
                pre++;
            }else {//在以1为前缀的范围里
                m--;
                if(m==0) break;
                pre*=10;

            }
        }
        return pre;
    }

    public int getCntOfPre(int pre, int n) {
        int c=1;
        for (int p=10;pre*p<=n;p*=10){
            if(pre*p+p-1>n){
                c+=n-pre*p+1;
            }else {
                c+=p;
            }
        }
        return c;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Scanner in = new Scanner(System.in);
//        String[] ss1 = in.nextLine().split(" ");
//        int[] d1 = new int[ss1.length];
//        for (int i = 0; i < ss1.length; i++) {
//            d1[i] = Integer.parseInt(ss1[i]);
//        }
//        int[] d = new int[d1[0]];
//        String[] ss = in.nextLine().split(" ");
//        for (int i = 0; i < ss.length; i++) {
//            d[i] = Integer.parseInt(ss[i]);
//        }
//        System.out.println(solution.needNum(d1[1], d));
        System.out.println(solution.solve(11,3));
    }
}