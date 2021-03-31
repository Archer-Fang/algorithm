package Interview.qali.q1;

import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/3/29 19:03
 **/
class Solution{
    public int getN(int n,int[] scores){
        int max=-1;
        int sum=0;
        for (int i=0;i<n;i++){
            max=Math.max(max,scores[i]);
            sum+=scores[i];
        }
        return 2*sum/n+1;
    }
}
public class q1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        String[] scores=in.nextLine().split(" ");
        int[] scores2=new int[scores.length];
        for(int i=0;i<scores.length;i++){
            scores2[i]=Integer.parseInt(scores[i]);
        }


        Solution solution=new Solution();
        System.out.println(solution.getN(n,scores2));
    }
}
