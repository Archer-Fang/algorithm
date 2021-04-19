package Interview.qtenxunv2.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/18 21:36
 **/

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int[] vis;

    public int needNum(int[] nums1, int[] nums2) {
        vis = new int[nums1.length+1];
        int[][] nums = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o2[1] - o1[1];
                else return o1[0] - o1[0];
            }
        });

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!putItem(nums[i][0])){
                sum+=nums[i][1];
            }
        }
        return sum;
    }

    //如果当前时间没有被放，则放到当前时间，否则放到前面没有被访问过的时间上去，如果都放不下则加入惩罚。
    public Boolean putItem(int id) {
        while (id>0&&vis[id]==1){id--;};
        if(id==0) return false;
        else {vis[id]=1; return true;}
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        LinkedList<Integer> l = new LinkedList<>();
        while ((T--) > 0) {
            int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] d2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.needNum(d1, d2));
        }
//1
//3 1 1 2
//3 6 9 6

        //out:6


    }
}
