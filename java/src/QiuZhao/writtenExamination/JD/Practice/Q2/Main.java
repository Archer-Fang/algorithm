package QiuZhao.writtenExamination.JD.Practice.Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/9/11 15:27
 **/
//3
//1 4 2
//4 3 2
//2 5 3
public class Main {
    public static int ans=0;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(in.nextLine());
        System.out.println(solve(n));
    }

    public static int solve(int n){
        int[][] d = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            d[i]= Arrays.stream(s).mapToInt(num->{
                return Integer.parseInt(num);
            }).toArray();
        }
//        Arrays.sort(d, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0]!=o2[0]){
//                    return o1[0]-o2[0];
//                }
//                if(o1[1]!=o2[1]){
//                    return o1[1]-o2[1];
//                }
//                return o1[2]-o2[2];
//
//            }
//        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(d[i][0]<d[j][0]&&d[i][1]<d[j][1]&&d[i][2]<d[j][2]) {ans++;break;}
            }
        }
        return ans;

    }

}
