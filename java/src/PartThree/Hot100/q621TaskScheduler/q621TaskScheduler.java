package PartThree.Hot100.q621TaskScheduler;

import java.util.Arrays;

//Java：任务调度器
public class q621TaskScheduler{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.leastInterval(new char[]{'A','A','A','B','B','B'},2));
        System.out.println(solution.leastInterval(new char[]{'A','A','A','B','B','B'},0));
        System.out.println(solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] tong = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            tong[task - 'A'] += 1;
        }
        Arrays.sort(tong);
        int c = 0;
        for (int i = 25; i > -1; i--) {
            if (tong[i] != tong[25]) break;
            c++;
        }
        return Math.max((tong[25] - 1) * (n + 1) + c, tasks.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
