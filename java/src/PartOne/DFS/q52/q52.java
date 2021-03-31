package PartOne.DFS.q52;

import java.util.HashSet;

/**
 * @author Created by Fangzj
 * @data 2021/3/15 16:12
 **/
class Solution {

    public int totalNQueens(int n) {
        HashSet<Integer> cols=new HashSet<>();
        HashSet<Integer> dgLeft=new HashSet<>();
        HashSet<Integer> dgRight=new HashSet<>();
        return dfs(n,0,cols,dgRight,dgLeft);
    }
    public int dfs(int n,int row,HashSet<Integer> cols,HashSet<Integer> dgRight,HashSet<Integer> dgLeft){
        if(row==n) return 1;
        else {
            int count=0;
            for(int i=0;i<n;i++){
                if(cols.contains(i)) continue;
                if(dgRight.contains(row-i)) continue;
                if(dgLeft.contains(row+i)) continue;
                cols.add(i);
                dgRight.add(row-i);
                dgLeft.add(row+i);
                count+=dfs(n,row+1,cols,dgRight,dgLeft);
                cols.remove(i);
                dgRight.remove(row-i);
                dgLeft.remove(row+i);
            }
            return count;
        }

    }
}

public class q52 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}
