package PartOne.DFS.q200;

/**
 * @author Created by Fangzj
 * @data 2021/3/12 20:43
 **/
class Solution {
    int c=0;
    public int numIslands(char[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;
    }

    public void dfs(char[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0') return ;
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}

public class q200 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        char[][] grid={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(grid));
    }
}
