package PartThree.Mid.q547NumberOfProvinces;
//Java：省份数量

public class q547NumberOfProvinces{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            int[] ints = isConnected[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if(anInt==1){
                    uf.union(i,j);
                }
            }
        }

        return uf.areaCount;
    }
}
class UF{
    int M;
    int[] parent;
    int areaCount;
    public UF(int m) {
        areaCount=m;
        M = m;
        parent=new int[M];
        for (int i = 0; i < M; i++) {
            parent[i]=i;
        }
    }
    public int find(int x){
        if(x!=parent[x]){
            return find(parent[x]);
        }
        return x;
    }
    public void union(int x,int y){
        int tmp1=find(x);
        int tmp2=find(y);
        if(tmp1==tmp2) return;
        areaCount--;
        parent[tmp1]=tmp2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
