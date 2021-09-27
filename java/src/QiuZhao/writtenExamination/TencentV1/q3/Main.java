package QiuZhao.writtenExamination.TencentV1.q3;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/9/5 21:00
 **/
public class Main {
    public static void main(String[] args) {
        //10 3 10
        //ans:5
        //66666 12345 54321
        //10->[5,0,5]->[1,0,1,1,1,0,1,0,1,0,1,1,1,0,1]
        Scanner in = new Scanner(System.in);
        int[] line1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=line1[0];
        String[] dp=new String[3];
        dp[0]="0";
        dp[1]="1";
        dp[2]="101";
        String s = get(n, dp);
        System.out.println(s);
        StringBuffer buffer = new StringBuffer();
        String[] split = "1,0,1,1,1,0,1,0,1,0,1,1,1,0,1".split(",");
        Arrays.stream(split).forEach(i->buffer.append(i));
        System.out.println(buffer.toString());
        int ans=0;
        for(int i=line1[1]-1; i<line1[2];i++){
            if(s.charAt(i)=='1'){
                ans++;
            }
        }
        System.out.println(ans);

    }

    private static String get(int i, String[] r) {
        StringBuffer stringBuffer = new StringBuffer();
        if(i<=2) return stringBuffer.append(r[i]).toString();
        else return stringBuffer.append(get(i/2,r)+get(i%2,r)+get(i/2,r)).toString();
    }
}
