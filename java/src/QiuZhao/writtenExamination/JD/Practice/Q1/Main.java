package QiuZhao.writtenExamination.JD.Practice.Q1;

import java.util.Scanner;

/**
 * 完全多部图
 * 不会。
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a-- != 0) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            int row = 0;
            int wid = 0;
            int[] sum = new int[b + 1];
            for (int i = 0; i < c; i++)
            {
                row = sc.nextInt();
                wid = sc.nextInt();
                sum[row]++;
                sum[wid]++;
            }
            int t = 0;
            for (int i = 0; i < b - 1; i++)
            {
                int key = 0;
                for (int j = 1; j < b + 1; j++)
                    if (sum[j] == i)
                        key++;
                if ( b>key + i  && key != 0)
                {
                    t++;
                    break;
                }
            }
            if (t == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}