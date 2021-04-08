package Interview.qmeituanMyTwo.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/8 10:24
 **/

 import java.util.Arrays;
 import java.util.Scanner;

 class Solution {
     public int needNum(int n, int[] nums) {

         return -1;
     }
 }

 public class Main {
     public static void main(String[] args) {
         Solution solution = new Solution();
         Scanner in = new Scanner(System.in);
         String[] ss1 = in.nextLine().split(" ");
         int[] d1 = new int[ss1.length];
         for (int i = 0; i < ss1.length; i++) {
             d1[i] = Integer.parseInt(ss1[i]);
         }
         int[] d = new int[d1[0]];
         String[] ss = in.nextLine().split(" ");
         for (int i = 0; i < ss.length; i++) {
             d[i] = Integer.parseInt(ss[i]);
         }
         System.out.println(solution.needNum(d1[1], d));
         System.out.println(solution.needNum(10, new int[]{6, 5, 10}));
     }
 }