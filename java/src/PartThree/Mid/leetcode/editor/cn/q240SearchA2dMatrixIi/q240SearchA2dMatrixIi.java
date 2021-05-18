package PartThree.Mid.leetcode.editor.cn.q240SearchA2dMatrixIi;
//Java：搜索二维矩阵 II

public class q240SearchA2dMatrixIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.searchMatrix(new int[][]{{-1,3}},3);

//        solution.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int i=m-1,j=0;
        if(matrix[i][j]==target) return true;
        while (i>-1&&j<n){
            while (i>-1&&j<n&&matrix[i][j]>target){
                i--;
            }
            if(i>-1&&j<n&&matrix[i][j]==target) return true;
            j++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
