package ShiXi.tenxun.qtenxun.q2;

/**
 * @author Created by Fangzj
 * @data 2021/4/4 20:12
 **/


 import java.util.Scanner;
 import java.util.Stack;

class Solution {
     public int needNum(int n, String data) {
         Stack<Integer> stack=new Stack<>();
         for (int i=0;i<data.length();i++){
             int tmp=Integer.parseInt(String.valueOf(data.charAt(i)));
             if(!stack.isEmpty()&&stack.peek()+tmp==10){
                 stack.pop();
             }else {
                 stack.push(tmp);
             }
         }
         StringBuffer sb=new StringBuffer();
         while (!stack.isEmpty()){
             sb.append(stack.pop());
         }
        return sb.reverse().toString().length();
     }
 }

 public class Main {
     public static void main(String[] args) {
         Solution solution = new Solution();
         Scanner in = new Scanner(System.in);
         String ss1 = in.nextLine();
         String ss2 = in.nextLine();

         System.out.println(solution.needNum(Integer.parseInt(ss1), ss2));
     }
 }
