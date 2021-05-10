package PartThree.q79;

/**
 * @author Created by Fangzj
 * @data 2021/5/10 21:37
 **/
class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        int[][] visit=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(word.charAt(0)==board[i][j]){
                    if(dfs(i,j,board,word,visit,0)){
                        return true;
                    }
                }

            }
        }
        return false;

    }

    private boolean dfs(int i, int j, char[][] board, String word, int[][] visit,int index) {
        if(word.length()==index) {
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||visit[i][j]==1||word.charAt(index)!=board[i][j]){
            return false;
        }
        visit[i][j]=1;
        index=index+1;
        boolean flag=dfs(i+1,j,board,word,visit,index)||dfs(i,j+1,board,word,visit,index)||dfs(i-1,j,board,word,visit,index)||dfs(i,j-1,board,word,visit,index);
        visit[i][j]=0;

        return flag;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
        System.out.println(solution.exist(new char[][]{{'A'}},"A"));
    }
}
