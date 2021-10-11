package QiuZhao.writtenExamination.PDD.q1;

import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/11 18:49
 **/
//1
//3 7
//.*...*.
//***.***
//.*...*.

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=Integer.parseInt(in.nextLine());
        StringBuffer ans = new StringBuffer();

        while ((T--)>0){
            int N=Integer.parseInt(in.nextLine());
            int l=0;
            boolean flag=true;
            for (int i = 0; i < N; i++) {
                String s = in.nextLine();
                if(l>s.length()&&flag){
                    ans.append("NO ");
                    flag=false;
                }
                l=s.length();

            }
            if(flag) ans.append("YES ");

        }
        String string = ans.toString();
        String[] p=string.substring(0,string.length()-1).split(" ");

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }



    }



}
