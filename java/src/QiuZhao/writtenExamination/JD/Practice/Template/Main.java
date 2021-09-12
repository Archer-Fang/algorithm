package QiuZhao.writtenExamination.JD.Practice.Template;

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
        int T = Integer.parseInt(in.nextLine());
        while ((T--) > 0) {
            int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = d1[0], k = d1[1];
            int[] num = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            solution.needNum(n, k, num);
        }

    }
}
//1
//3 3
//3
//6
//9