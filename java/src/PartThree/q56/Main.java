package PartThree.q56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/5/10 19:54
 **/
class Solution {
    public int[][] merge(int[][] intervals) {
        //对第一维进行排序
        //DP
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> ans=new LinkedList<>();

        int[] tmp=new int[]{intervals[0][0],intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if(tmp[1]>=intervals[i][0]){
                tmp[1]=Math.max(tmp[1],intervals[i][1]);
            }else {
                ans.add(new int[]{tmp[0],tmp[1]});
                tmp=new int[]{intervals[i][0],intervals[i][1]};
            }
        }
        ans.add(new int[]{tmp[0],tmp[1]});
        return ans.toArray(new int[ans.size()][2]);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.merge(new int[][]{{1,4},{2,3}}));
    }
}
