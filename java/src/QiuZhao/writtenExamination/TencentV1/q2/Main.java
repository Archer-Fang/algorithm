package QiuZhao.writtenExamination.TencentV1.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/9/5 19:51
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = Integer.parseInt(in.nextLine());
        int[] line1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] line2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] r1=getR(line1);
        int[] r2=getR(line2);
        Arrays.sort(r1);
        Arrays.sort(r2);
        int c1=0,c2=0,ans=0;
        while (c1<r1.length&&c2<r2.length){
            if(r1[c1]>r2[c2]){
                c1++;
                c2++;
                ans++;
            }else {
                c1++;
            }
        }
        System.out.println(ans);
    }

    private static int[] getR(int[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i]=get(input[i]);
        }
        return input;
    }

    private static int get(int i) {
        int c=0;
        for (int j = 1; j < Math.sqrt(i); j++) {
            if(i%j==0){
                c+=2;
            }
        }
        if(Math.sqrt(i)*Math.sqrt(i)==i) c++;
        return c;
    }


}

