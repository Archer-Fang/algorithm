package Interview.qmeituanv2.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 10:03
 **/

import java.util.Scanner;

class Solution {
    public long needNum(String data) {
        //以a为结尾的个数2，以b结尾的个数3=2+1，以c为结尾的个数5=3+2+1，加空 12

        int[] num = new int[26];
        int MOD=20210101;
        for (Character c:data.toCharArray()){
            num[c-'a']++;
        }
        long res=1;
        for (int i=0;i<26;i++){
            res*=(num[i]+1)%MOD;
        }
        return res;

    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
//         String[] ss1 = in.nextLine().split(" ");
//         int[] d1 = new int[ss1.length];
//         for (int i = 0; i < ss1.length; i++) {
//             d1[i] = Integer.parseInt(ss1[i]);
//         }
//         int[] d = new int[d1[0]];
//         String[] ss = in.nextLine().split(" ");
//         for (int i = 0; i < ss.length; i++) {
//             d[i] = Integer.parseInt(ss[i]);
//         }
//         System.out.println(solution.needNum(in.nextLine()));
        System.out.println(solution.needNum("aabc"));
    }
}