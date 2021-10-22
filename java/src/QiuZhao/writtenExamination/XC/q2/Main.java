package QiuZhao.writtenExamination.XC.q2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/21 18:56
 **/
//第一行两个正整数n和m，分别表示这一天有n个时刻，以及有m个人来游泳馆。
//
//第二行m个数，第i个数a[i]表示第i个人进入泳池的时刻。
//
//第三行m个数，第i个数b[i]表示第i个人离开泳池的时刻。
//
//数字间两两有空格隔开
//
//n<=1000000000, m<=50000, 1<=a[i]<b[i]<=n

//12 3
//4 3 8
//7 6 10

//5

public class Main {
    public static void main(String[] args) {
        //思路：区间合并
        //3个人在泳池的时间段分别是[4, 7]、[3, 6]、[8, 10]。那么[1, 3]、[7, 8]、[10, 12]这三个时段泳池内是没有人的
        //[3, 6]、[4, 7]、[8, 10]
        //下个时刻在这个区间内，合并。
        //否则单独领出来。
        //[3,7] [8,10] +1+2
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int n=nums[0],m=nums[1];
        int[][] arr = new int[m][2];
        int[] nums2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] nums3 = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        for (int i = 0; i < nums2.length; i++) {
            arr[i][0]=nums2[i];
            arr[i][1]=nums3[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        LinkedList<int[]> timestamp = new LinkedList<>();
        int k=0;
        while (k<arr.length){
            if(k+1<arr.length&&arr[k+1][0]<=arr[k][1]&&arr[k+1][0]>=arr[k][0]){
                arr[k+1][1]=Math.max(arr[k][1],arr[k+1][1]);
                arr[k+1][0]=arr[k][0];
            }else{
                timestamp.add(arr[k]);
            }
            k++;
        }
        int ans=0;
        ans+=timestamp.get(0)[0]-1;
        for (int i = 1; i < timestamp.size(); i++) {
            int[] t1 = timestamp.get(i-1);
            int[] t2 = timestamp.get(i);
            ans+=t2[0]-t1[1];
        }
        ans+=n-timestamp.get(timestamp.size()-1)[1];
        System.out.println(ans);


    }
}
