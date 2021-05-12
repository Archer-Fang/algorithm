package Interview.qmeituanv2.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 10:52
 **/

 import java.util.LinkedList;

class Solution {
     public int needNum(int[] nums,int k) {
         int c=0;
         for (Integer num:nums){
             String tmp=getPart(num);
             if(tmp.contains(String.valueOf(k))) c++;
         }
         return c;

     }
     public String getPart(int n){
         StringBuffer sb=new StringBuffer();
         LinkedList l=new LinkedList();
         for (int i=1;i<=Math.sqrt(n);i++){
             if(n%i==0){
                 sb.append(i);
                 l.addFirst(n/i);
             }
         }
         while (!l.isEmpty()){
             sb.append(l.removeFirst());
         }
         return sb.toString();
     }
 }

 public class Main {
     public static void main(String[] args) {
         Solution solution = new Solution();
//         Scanner in = new Scanner(System.in);
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
//         System.out.println(solution.needNum( d,d1[1]));
         System.out.println(solution.needNum(new int[]{13,31, 10, 9, 20},13));
     }
 }
