package ShiXi.meituan.qmeituanv2.q5;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 11:38
 **/

class Solution {

    public int needNum(int n,int m, int[] numsA,int[] numsB) {
        //分别求两个数组最大和即可
        return -1;
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
//         int[] d2 = new int[d1[1]];
//         String[] ss2 = in.nextLine().split(" ");
//         for (int i = 0; i < ss2.length; i++) {
//             d2[i] = Integer.parseInt(ss2[i]);
//         }
//         System.out.println(solution.needNum(d1[0],d1[1],d,d2));

         System.out.println(solution.needNum(3,4, new int[]{1,-1,0}, new int[]{2,2,-5,3}));
     }
 }