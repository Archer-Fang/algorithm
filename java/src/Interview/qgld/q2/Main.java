package Interview.qgld.q2;

/**
 * @author Created by Fangzj
 * @data 2021/4/21 19:07
 **/

import java.util.*;

class Solution {
    public String needNum(char[][] nums) {
        int[][] visit=new int[nums.length][nums.length];
        StringBuffer sb=new StringBuffer();
        dfs(nums,0,0,sb,visit);
//        System.out.println(sb);
        return sb.toString();
    }
    public void dfs(char[][] nums,int i,int j,StringBuffer sb,int[][] visit){

        if(visit[i][j]==1) return;
        while (j<nums.length&&visit[i][j]==0){
            if(nums[i][j]=='0') return;
            sb.append(nums[i][j]);
            visit[i][j]=1;
            j++;
        }
        j--;
        i++;
        while (i<nums.length&&visit[i][j]==0){
            if(nums[i][j]=='0') return;
            sb.append(nums[i][j]);
            visit[i][j]=1;
            i++;
        }
        i--;
        j--;
        while (j>-1&&visit[i][j]==0){
            if(nums[i][j]=='0') return;
            sb.append(nums[i][j]);
            visit[i][j]=1;
            j--;
        }
        j++;
        i--;
        while (i>-1&&visit[i][j]==0){
            if(nums[i][j]=='0') return;
            sb.append(nums[i][j]);
            visit[i][j]=1;
            i--;
        }
        i++;
        j++;
        dfs(nums,i,j,sb,visit);

    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        char[][] nums=new char[T][T];
        for (int i=0;i<T;i++){

            nums[i]= in.nextLine().toCharArray();
        }
        System.out.println(solution.needNum(nums));


    }
}
//1
//3 3
//3
//6
//9
//
//4
//qwef
//awad
//s00s
//asdf