package QiuZhao.writtenExamination.HW.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/20 18:57
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M=Integer.parseInt(in.nextLine());
        int[] Pm = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int N=Integer.parseInt(in.nextLine());
        int[] s = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        boolean flag=false;
        for (int i = 0; i < s.length; i++) {
            if(s[i]>Pm.length-1||M>N){
                flag=true;
            }

        }
        if(flag) {
            System.out.println("-1");
            return;
        }




    }
}
