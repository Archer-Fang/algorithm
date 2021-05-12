package PartThree.Mid.leetcode.editor.cn.q130SurroundedRegions;
//Java：被围绕的区域
public class q130SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for (int i = 0; i < n; i++) {
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(board,0,i);
            dfs(board,n-1,i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j]=board[i][j]=='A'?'O':'X';
            }
        }

    }
    public void dfs(char[][] board,int x,int y){
        if(x<0||y<0||x>=board.length||y>=board[0].length||board[x][y]!='O'){
            return;
        }
        board[x][y]='A';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
