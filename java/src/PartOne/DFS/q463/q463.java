package PartOne.DFS.q463;

/**
 * @author Created by Fangzj
 * @data 2021/3/19 11:00
 **/
//4,4,4/6
class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j);
                }
            }
        }
        return 4;
    }
    public int dfs(int[][] grid,int row,int col) {
        if(row<0||row>=grid.length||col<0||col>=grid[0].length) return 1;
        if(grid[row][col]==0) return 1;
        if(grid[row][col]==2) return 0;
        grid[row][col]=2;
        return dfs(grid,row+1,col)+dfs(grid,row-1,col)+dfs(grid,row,col+1)+dfs(grid,row,col-1);
    }
}
public class q463 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        System.out.println(solution.islandPerimeter(new int[][]{{1}}));
        System.out.println(solution.islandPerimeter(new int[][]{{1,0}}));
    }
}
