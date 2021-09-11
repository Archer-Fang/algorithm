package ShiXi.qjd.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/24 20:20
 **/

import java.util.*;

class Solution {
    public void needNum(int n, int k, int[] nums) {
        //一有结果直接sout
        return;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);

        int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = d1[0], m = d1[1];
        int[] num = new int[m];
        int[] d2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <n ; i++) {
            num[d2[i]-1]++;
        }
        int[] r=new int[2];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if(num[i]>max){
                max=num[i];
                r[0]=i+1;
                r[1]=max;
            }
        }
        System.out.println(r[0]+" "+r[1]);

    }
}
//5 4
//1 1 2 3 4
