package ShiXi.qbaidu.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/11 19:34
 **/

 import java.util.LinkedList;
 import java.util.Scanner;

 class Solution {
     public int needNum(int a,int b) {
         int max=Math.max(a,b);
         int min=Math.min(a,b);
         if(a==b) return 0;
         if(a/2==b) return 1;
         int c=0;
         while (max>min){
             max/=2;
             c++;
             if(max<min){
                 int temp=max;
                 max=min;
                 min=temp;
             }
         }
         return c;
     }
 }

 public class Main {
     public static void main(String[] args) {
//         3
//1 2
//4 14
//8 5

         //1
         //5
         //3
         Solution solution = new Solution();
         Scanner in = new Scanner(System.in);
         int T=Integer.parseInt(in.nextLine().split(" ")[0]);
         LinkedList<Integer> l=new LinkedList<>();
         while ((T--)>0){
             String[] ss1 = in.nextLine().split(" ");
             int[] d1 = new int[ss1.length];
             for (int i = 0; i < ss1.length; i++) {
                 d1[i] = Integer.parseInt(ss1[i]);
             }
             l.add(solution.needNum(d1[0],d1[1]));
         }

         for (Integer tmp:l){
             System.out.println(tmp);
         }

//         System.out.println(solution.needNum(1,2));
//         System.out.println(solution.needNum(4,14));
//         System.out.println(solution.needNum(8,5));
     }
 }
