package nowcoder.meituan.ten.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/9 20:46
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] s = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        Arrays.sort(s);
        int sum=0;
        for (int i = 1; i <=s.length ; i++) {
            sum+=Math.abs(i-s[i-1]);
        }
        System.out.println(sum);

    }
}
