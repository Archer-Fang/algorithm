package Interview.qtenxunMy.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 20:30
 **/

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int needNum(int n, int[] nums) {
        //hanuota
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        if (n == 3) {
            int sum=0;
            for (int i=0;i<n;i++){
                sum+=nums[i];
            }
            return sum;
        }
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];
        int cnt = 0;
        int i = n - 1;

        while (i > 2) {
            cnt += a + b + nums[i] + b;
            i -= 2;

        }
        if (i == 2) {
            cnt += nums[0] + nums[1] + nums[2];
        }
        if (i == 1) {
            cnt += b;
        }

        return cnt;
    }

}

public class Main {
    public static void main(String[] args) {
        //         2
        //         3
        //         3 6 9
        //         4
        //         10 1 5 2
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while ((T--) > 0) {
            int n = Integer.parseInt(in.nextLine());
            int[] d1 = new int[n];
            String[] ss1 = in.nextLine().split(" ");
            for (int i = 0; i < ss1.length; i++) {
                d1[i] = Integer.parseInt(ss1[i]);
            }
            System.out.println(solution.needNum(n, d1));

        }
//     System.out.println(solution.needNum(5,new int[]{1,2,3,4,5}));


    }
}
