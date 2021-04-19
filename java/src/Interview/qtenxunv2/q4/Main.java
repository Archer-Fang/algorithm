package Interview.qtenxunv2.q4;

/**
 * @author Created by Fangzj
 * @data 2021/4/18 20:52
 **/

 import java.util.Arrays;
 import java.util.LinkedList;
 import java.util.Scanner;

class Solution {
    public Boolean needNum(String s,String s2) {

        if(s.length()%2==1){
            for (int i=0;i<s.length();i++){
                if(s.charAt(i)!=s2.charAt(i)) return false;
            }
            return true;
        }
        else{
            return dfs(s.substring(0,s.length()/2),s.substring(s.length()/2,s.length()),s2.substring(0,s2.length()/2),s2.substring(s2.length()/2,s2.length()));
        }
    }
    public Boolean dfs(String a1,String a2,String b1,String b2){
        if(a1.length()%2==1){
            if((a1.equals(b1)&&a2.equals(b2))||(a1.equals(b2)&&a2.equals(b1))) return true;
            else return false;
        }
        else if(a1.length()%2==0){
            Boolean flag1=dfs(a1.substring(0,a1.length()/2),a1.substring(a1.length()/2, a1.length()),b1.substring(0,b1.length()/2),b1.substring(b1.length()/2, b1.length()))&&dfs(a2.substring(0,a2.length()/2),a2.substring(a2.length()/2, a2.length()),b2.substring(0,b2.length()/2),b2.substring(b2.length()/2, b2.length()));
            Boolean flag2=dfs(a1.substring(0,a1.length()/2),a1.substring(a1.length()/2, a1.length()),b2.substring(0,b2.length()/2),b2.substring(b2.length()/2, b2.length()))&&dfs(a2.substring(0,a2.length()/2),a2.substring(a2.length()/2, a2.length()),b1.substring(0,b1.length()/2),b1.substring(b1.length()/2, b1.length()));
            return flag1||flag2;
        }
        return true;
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
//         System.out.println(solution.needNum(d1[1], d));
//         System.out.println(solution.needNum(10, new int[]{6, 5, 10}));
         //4
         //aaba
         //abaa
         //aabb
         //abab
         //aaabbb
         //bbbaaa
         //cba
         //abc
         Scanner in = new Scanner(System.in);
         LinkedList<Boolean> l=new LinkedList<>();
         int k=Integer.parseInt(in.nextLine());
         for (int i=0;i<k;i++){
             String a=in.nextLine();
             String b=in.nextLine();
             if(solution.needNum(a,b)) System.out.println("YES");
             else System.out.println("NO");
         }
//
//         System.out.println(solution.needNum("aaba","abaa"));
//         System.out.println(solution.needNum("aabb","abab"));
//         System.out.println(solution.needNum("aaabbb","bbbaaa"));
//         System.out.println(solution.needNum("cba","abc"));
         //YES
         //NO
         //YES
         //NO
     }
 }
