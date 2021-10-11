package QiuZhao.writtenExamination.Meituan.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/10 9:52
 **/
public class Main {
    public static void main(String[] args) {
        //第一行三个正整数n,m,k(1≤n,m≤200,1≤k≤106)，分别表示健身操的动作数量，小美的实际动作数量，阈值。
        //
        //接下来n行，每行三个正整数l,r,v，表示健身操的动作为，l~r时刻，动作v。保证按时间升序给出指令，各个动作的时间段没有重叠的部分。
        //
        //接下来m行，每行三个正整数l,r,v，表示小美的实际动作为，l~r时刻，动作v。保证按时间升序给出指令，各个动作的时间段没有重叠的部分。
        //
        //0≤l≤r≤106

        //3 3 2
        //1 2 0
        //5 6 1
        //8 10 1
        //0 3 0
        //5 6 0
        //7 9 1

        //4
        //小错误分别在0~1 , 2~3 , 5~6 , 7~8 ； 根据题意，应该做某个动作而没有做某个动作不算“错误操作”故9~10不在错误的定义内
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int n=nums[0],m=nums[1],k=nums[2];
        int[][] requires = new int[n][3];
        int[][] actions = new int[m][3];
        for (int i = 0; i < n; i++) {
            requires[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        }
        for (int i = 0; i < m; i++) {
            actions[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        }
        int sum=0;

        for (int i = 0; i < m; i++) {
            //1.找动作对应的区间。
            //2.判断错误对应的次数

            sum+=findTimeAndCount(actions[i],requires);
        }
        System.out.println(sum);





    }

    private static int findTimeAndCount(int[] action, int[][] requires) {
        for (int i = 0; i < requires.length; i++) {
            if(requires[i][2]==action[2]){
                //require包含action
                if(requires[i][0]<=action[0]&&requires[i][1]>=action[1]){
                    return 0;
                }
                //action包含require
                else if(requires[i][0]>action[0]&&requires[i][1]<action[1]){
                    return 2;
                }
                //不匹配
                else if(requires[i][0]>action[1]||requires[i][1]<action[0]){ continue;}
                else return 1;
            }
            else {
                //require包含action
                if(requires[i][0]<=action[0]&&requires[i][1]>=action[1]){
                    return 1;
                }
                //action包含require
                else if(requires[i][0]>action[0]&&requires[i][1]<action[1]){
                    return 3;
                }
                //不匹配
                else if(requires[i][0]>action[1]||requires[i][1]<action[0]){ continue;}
                else return 2;
            }

        }
        return 0;
    }
}
