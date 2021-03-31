package PartOne.DFS.q1162;

import java.util.ArrayDeque;

/**
 * @author Created by Fangzj
 * @data 2021/3/18 21:39
 **/
class Solution {
    public int maxDistance(int[][] grid) {
        ArrayDeque<int[]> queue=new ArrayDeque<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    queue.add(new int[]{i,j});
            }
        }
        int[] point=new int[2];
        int[] xs={-1,1,0,0};
        int[] ys={0,0,-1,1};
        Boolean hasOcean =false;
        while (!queue.isEmpty()){
            point=queue.removeFirst();
            for (int i=0;i<4;i++){
                if(point[0]+xs[i]>=grid[0].length||point[0]+xs[i]<0||point[1]+ys[i]>=grid.length||point[1]+ys[i]<0||grid[point[0]+xs[i]][point[1]+ys[i]]!=0) continue;
                grid[point[0]+xs[i]][point[1]+ys[i]]=grid[point[0]][point[1]]+1;
                hasOcean=true;
                queue.add(new int[]{point[0]+xs[i],point[1]+ys[i]});
            }
        }
        if(!hasOcean||point==null) return -1;

        return grid[point[0]][point[1]]-1;
    }

}

public class q1162 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }
}
