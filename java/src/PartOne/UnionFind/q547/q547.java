package PartOne.UnionFind.q547;

/**
 * @author Created by Fangzj
 * @data 2021/3/19 21:03
 **/
class Solution {

    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind=new UnionFind(isConnected.length);
        for (int i=0;i<isConnected.length;i++){
            for (int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1&&i!=j) unionFind.union(i,j);
            }
        }
        return unionFind.areaCount;
    }

    class UnionFind{
        private int[] parent;
        private int[] size;
        private int areaCount;
        UnionFind(int num){
            parent=new int[num];
            size=new int[num];
            for (int i=0;i<num;i++) {parent[i]=i;size[i]=1;}
            areaCount=num;
        }
        public int find(int x){
            while (parent[x]!=x){
                x=find(parent[x]);
            }
            return x;
        }
        public Boolean isConnect(int i,int j){
            return find(i)==find(j)?true:false;
        }
        public void union(int pp,int qq){
            int leader_pp=find(pp);
            int leader_qq=find(qq);
            if(leader_pp==leader_qq) return;
            areaCount--;
            if(size[leader_pp]>size[leader_qq]){
                parent[leader_qq]=leader_pp;
                size[leader_pp]+=size[leader_qq];
            }else {
                parent[leader_pp]=leader_qq;
                size[leader_qq]+=size[leader_pp];
            }
        }
    }

}

public class q547 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));


    }
}

