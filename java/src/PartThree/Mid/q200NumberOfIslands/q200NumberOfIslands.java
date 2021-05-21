package PartThree.Mid.q200NumberOfIslands;
//Java：岛屿数量

public class q200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;

    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
