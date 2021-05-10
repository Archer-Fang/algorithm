package PartThree.q48;

/**
 * @author Created by Fangzj
 * @data 2021/5/8 20:55
 **/
class Solution {
    public void rotate(int[][] matrix) {
        //先以对角线旋转45。
        //(0,0),(2,2) (0,1),(1,2) (1,0),(2,1)
        int n=matrix.length;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n-i; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1]=tmp;
            }
        }
        //以中间轴翻转
        for(int i=0;i<matrix.length/2;i++){
            for (int j = 0; j <matrix[0].length ; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j]=tmp;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(ints);
    }
}
