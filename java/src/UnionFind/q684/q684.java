package UnionFind.q684;

/**
 * @author Created by Fangzj
 * @data 2021/3/21 11:27
 **/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind=new UnionFind(edges.length+1);

        for(int[] edge:edges){
            if(unionFind.isConnect(edge[0],edge[1])) return edge;
            unionFind.union(edge[0],edge[1]);
        }
        return new int[]{0, 0};
    }

    class UnionFind{
        int[] parent;
        int[] size;
        UnionFind(int num){
            parent=new int[num];
            size=new int[num];
            for (int i=0;i<num;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        public Boolean isConnect(int a,int b){
            return find(a)==find(b)?true:false;
        }
        public int find(int x){
            return x==parent[x]?x:find(parent[x]);
        }
        public void union(int a,int b){
            int leader_a=find(a);
            int leader_b=find(b);
            if(size[leader_a]>size[leader_b]){
                parent[leader_b]=leader_a;
                size[leader_a]+=size[leader_b];
            }
            else {
                parent[leader_a]=leader_b;
                size[leader_b]+=size[leader_a];
            }
        }

    }
}
public class q684 {
}
