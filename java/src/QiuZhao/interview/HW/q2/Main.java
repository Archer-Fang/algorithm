package QiuZhao.interview.HW.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/22 14:29
 **/
public class Main {
    public static void main(String[] args) {
        //(这是一个10阶的螺旋三角)看清楚以上图的数字排列的规律了吧，你的任务就是给定任意的n，输出n阶的螺旋三角。
        //
        //解答要求
        //时间限制：1000ms, 内存限制：64MB
        //输入
        //输入一个整数n(2<n<=10)，输入到文件末尾结束。
        //输出
        //输出对应的螺旋三角，每个螺旋三角的数字之间有一个空格哦，并不需要像描述中的格式对齐。
        //样例
        //输入样例 1 复制
        //10
        //输出样例 1
//1 2 3 4 5 6 7 8 9 10
//27 28 29 30 31 32 33 34 11
//26 45 46 47 48 49 35 12
//25 44 54 55 50 36 13
//24 43 53 51 37 14
//23 42 52 38 15
//22 41 39 16
//21 40 17
//20 18
//19
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[][] map = new int[n][n];
        //以顺时针进行遍历。
        //10->4圈
        //1->1
        //2->1
        //3->1
        //4->2
        //5->2
        //6->2
        //7->3
        //8->3
        //9->3


        int offv=0;
        int k= n/3;
        int c=1;
        int startx=0;
        int starty=0;
        while ((k--)>0){
            //先考虑最外一圈。
            //考虑内圈。
            int i = startx;
            int j = starty;
            //l->r
            for ( j = starty; j < n-offv-1; j++) {
                map[startx][j]=c;
                c++;
            }
            //对角线
            for ( i = startx; i+offv<n-1; i++) {
                map[i][j--]=c;
                c++;
            }
            //bottom->up
            for ( ; i>startx ; i--) {
                map[i][starty]=c;
                c++;
            }
            offv+=2;
            startx++;
            starty++;

            for ( i = 0; i < n; i++) {
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println();

        }
        map[startx][starty]=c;
        String ans="";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]==0) continue;
                ans+=map[i][j]+" ";
            }
            ans+="\n";

        }
        System.out.println(ans);



    }
}
