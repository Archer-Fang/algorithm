package PartThree.Mid.q96UniqueBinarySearchTrees;

//Java：不同的二叉搜索树
public class q96UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int numTrees(int n) {
        int[] visit=new int[n+1];
        return dfs(n,visit);
    }

    private int dfs( int n ,int[] visit) {
        if(n<=1) return 1;
        if(visit[n]!=0) return visit[n];
        int sum=0;
        for (int j = 1; j < n + 1; j++) {
            int ls = dfs(j - 1,visit);
            int rs = dfs(n-j,visit);
            sum+=ls*rs;
        }
        visit[n]=sum;
        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
