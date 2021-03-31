package PartOne.DFS.q959;

/**
 * @author Created by Fangzj
 * @data 2021/3/19 11:30
 **/
class Solution {
    public int regionsBySlashes(String[] grid) {
        int[][] grid2=new int[grid.length*3][grid[0].length()*3];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length();j++){
                if(grid[i].charAt(j)=='/'){
                    grid2[3*i][3*j+2]=1;
                    grid2[3*i+1][3*j+1]=1;
                    grid2[3*i+2][3*j]=1;
                }
                if(grid[i].charAt(j)=='\\'){
                    grid2[3*i][3*j]=1;
                    grid2[3*i+1][3*j+1]=1;
                    grid2[3*i+2][3*j+2]=1;
                }
            }
        }
        int c=0;
        for (int i=0;i<grid2.length;i++){
            for (int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==0){
                    c++;
                    dfs(grid2,i,j);
                }
            }
        }
        return c;
    }

    public void dfs(int[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==1) return;
        grid[i][j]=1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return;
    }
}
public class q959 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.regionsBySlashes(new String[]{" /","/ "}));
    }
}
