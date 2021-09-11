package ShiXi.qbaidu.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/11 20:35
 **/

 import java.util.*;

class Solution {
     public String needNum(HashMap<Integer,HashSet<Integer>>win,HashMap<Integer,HashSet<Integer>> lose,int target,int n) {
         Queue<Integer> q=new LinkedList<>();
         q.add(target);
         HashSet<Integer> targetWin=new HashSet<>();
         HashSet<Integer> targetLost=new HashSet<>();
         while (!q.isEmpty()){
             int tmp=q.poll();
             HashSet<Integer> hashSet=win.getOrDefault(tmp,new HashSet<>());
             for (Integer i:hashSet){
                 if(!targetWin.contains(i)){
                     targetWin.add(i);
                     q.add(i);
                 }
             }
         }
         Queue<Integer> q2=new LinkedList<>();
         q2.add(target);
         while (!q2.isEmpty()){
             int tmp=q2.poll();
             HashSet<Integer> hashSet=win.getOrDefault(tmp,new HashSet<>());
             for (Integer i:hashSet){
                 if(!targetLost.contains(i)){
                     targetLost.add(i);
                     q2.add(i);
                 }
             }
         }
         HashSet<Integer> res=new HashSet<>();
         String ans="";
         for (int i=targetWin.size()+1;i<n+1;i++){
             res.add(i);
         }
         for (int i=1;i<n-targetLost.size()+1;i++){
             if(res.contains(i)){
                 ans+=" "+i;
             }
         }
         return ans.substring(1,ans.length());
     }
 }

 public class Main {
     public static void main(String[] args) {
         //4 3 4
         //1 2
         //2 3
         //4 3
         Solution solution = new Solution();
         Scanner in = new Scanner(System.in);
         String[] ss1 = in.nextLine().split(" ");
         int[] d1 = new int[ss1.length];
         for (int i = 0; i < ss1.length; i++) {
             d1[i] = Integer.parseInt(ss1[i]);
         }
         HashMap<Integer,HashSet<Integer>> win=new HashMap<>();
         HashMap<Integer,HashSet<Integer>> lose=new HashMap<>();
         for (int i=0;i<d1[1];i++){
             String[] ss = in.nextLine().split(" ");
             HashSet tmp=win.getOrDefault(Integer.parseInt(ss[0]),new HashSet<>());
             tmp.add(Integer.parseInt(ss[0]));
             win.put(Integer.parseInt(ss[0]),tmp);

             HashSet tmp2=lose.getOrDefault(Integer.parseInt(ss[1]),new HashSet<>());
             tmp.add(Integer.parseInt(ss[1]));
             lose.put(Integer.parseInt(ss[1]),tmp2);
         }

         System.out.println(solution.needNum(win,lose,d1[2],d1[0]));
     }
 }