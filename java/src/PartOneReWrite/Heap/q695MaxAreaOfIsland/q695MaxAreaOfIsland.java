package PartOneReWrite.Heap.q695MaxAreaOfIsland;

//Java：岛屿的最大面积
public class q695MaxAreaOfIsland{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int count=0;
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]!='0'){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+dfs(grid,i+1,j)+dfs(grid,i,j+1)+dfs(grid,i-1,j)+dfs(grid,i,j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
