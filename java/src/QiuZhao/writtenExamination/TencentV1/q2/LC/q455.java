package QiuZhao.writtenExamination.TencentV1.q2.LC;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/9/11 12:58
 **/
//q455:https://leetcode-cn.com/problems/assign-cookies/
public class q455 {
    static class Solution {
        public int findContentChildrenHeap(int[] g, int[] s) {
            int ans=0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a, b) -> {
                return b - a;
            });
            for (int i = 0; i < s.length; i++) {
                priorityQueue.add(s[i]);
            }
            Arrays.sort(g);
            for (int i = g.length-1; i >-1; i--) {
                if(!priorityQueue.isEmpty()&&priorityQueue.peek()>=g[i]){
                    ans++;
                    priorityQueue.poll();
                }
            }
            return ans;
        }
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int c1=0;
            int c2=0;
            int ans=0;
            while (c1<g.length&&c2<s.length){
                if(g[c1]<=s[c2]){
                    c1++;
                    c2++;
                    ans++;
                }else {
                    c2++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(solution.findContentChildren(g,s));

    }
}
