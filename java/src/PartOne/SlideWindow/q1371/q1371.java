package PartOne.SlideWindow.q1371;

import java.util.Arrays;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 21:31
 **/
class Solution {
    public int findTheLongestSubstring(String s) {
        int[] pre=new int[32];
        Arrays.fill(pre,Integer.MAX_VALUE);
        pre[0]=-1;
        int state=0;
        int max=0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') state^=1;
            if(s.charAt(i)=='e') state^=2;
            if(s.charAt(i)=='i') state^=4;
            if(s.charAt(i)=='o') state^=8;
            if(s.charAt(i)=='u') state^=16;
            if(pre[state]==Integer.MAX_VALUE) pre[state]=i;
            else {
                max=Math.max(max,i-pre[state]);
            }
        }
        return max;
    }
}
public class q1371 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findTheLongestSubstring("eleetminicoworoep"));
    }
}
