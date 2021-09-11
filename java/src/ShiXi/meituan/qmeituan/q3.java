package ShiXi.meituan.qmeituan;

import java.io.*;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/29 14:38
 **/
class Solution{
    public int[] getNs(int N,String item,int M,String MF){
        int[] tables=new int[N];
        PriorityQueue<Integer> zeros=new PriorityQueue<>();
        PriorityQueue<Integer> ones=new PriorityQueue<>();
        String[] persons=new String[M];
        for (int i=0;i<item.length();i++){
            tables[i]=Integer.parseInt(String.valueOf(item.charAt(i)));
            if(tables[i]==0){
                zeros.add(i);
            }else if(tables[i]==1){
                ones.add(i);
            }
        }
        for (int i=0;i<M;i++){
            persons[i]=String.valueOf(MF.charAt(i));
        }
        int[] ans=new int[M];
        for (int i=0;i<M;i++){
            if(persons[i].equals("M")){
                if(ones.size()!=0){
                    ans[i]=ones.poll();
                }else {
                    ans[i]=zeros.poll();
                    ones.add(ans[i]);
                }
            }
            if(persons[i].equals("F")){
                if(zeros.size()!=0){
                    ans[i]=zeros.poll();
                    ones.add(ans[i]);
                }else {
                    ans[i]=ones.poll();
                }
            }
        }
        for (int i=0;i<ans.length;i++){
            ans[i]=ans[i]+1;
        }
        return ans;
    }
}
public class q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(reader.readLine());
        while ((T--)>0){
            int N=Integer.parseInt(reader.readLine());
            String N2=reader.readLine();
            int N3=Integer.parseInt(reader.readLine());
            String N4=reader.readLine();
            Solution solution=new Solution();
            int[] ans=solution.getNs(N, N2, N3, N4);
            for (int i=0;i<ans.length;i++){
                writer.write(Integer.toString(ans[i]));
                writer.newLine();
            }
        }
        writer.flush();

    }
}
