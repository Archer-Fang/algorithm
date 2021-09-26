package PartOneReWrite.Heap.q1162AsFarFromLandAsPossible;

import java.util.LinkedList;
import java.util.Queue;

//Java：地图分析
public class q1162AsFarFromLandAsPossible{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxDistance(new int[][]{{1,0,0},{0,0,0},{0,0,0}});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[][] grid) {
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] xs=new int[]{0,0,1,-1};
        int[] ys=new int[]{1,-1,0,0};
        int[] poll = new int[2];
        boolean flag=false;
        while (!queue.isEmpty()){
            poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX=poll[0]+xs[i];
                int newY=poll[1]+ys[i];
                if(newX<0||newX>=grid.length||newY<0||newY>=grid.length||grid[newX][newY]!=0) continue;
                flag=true;
                grid[newX][newY]=grid[poll[0]][poll[1]]+1;
                queue.add(new int[]{newX,newY});
            }
        }
        if(!flag) return -1;
        return grid[poll[0]][poll[1]]-1;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
