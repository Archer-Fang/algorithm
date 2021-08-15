package PartFourCodeTop.q54SpiralMatrix;

import java.util.LinkedList;
import java.util.List;

//Java：螺旋矩阵
public class q54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}}));
        System.out.println(1);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        LinkedList ans = new LinkedList();
        int m=matrix.length,n=matrix[0].length;
        int[][] visited=new int[m][n];
        int i=0,j=0;
        int direction =0;
        for (int k = 0; k < m * n; k++) {
            ans.add(matrix[i][j]);
            visited[i][j]=1;
            if(direction==0&&(j+1==n||visited[i][j+1]==1)){
                direction=1;
            }else if(direction==1&&(i+1==m||visited[i+1][j]==1)){
                direction=2;
            }else if(direction==2&&(j-1==-1||visited[i][j-1]==1)){
                direction=3;
            }else if(direction==3&&(i-1==-1||visited[i-1][j]==1)){
                direction=0;
            }

            if(direction==0){
                j++;
            }else if(direction==1){
                i++;
            }else if(direction==2){
                j--;
            }else if(direction==3){
                i--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
