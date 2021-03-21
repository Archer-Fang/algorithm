package UnionFind.q1202;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/20 20:45
 **/
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind unionFind=new UnionFind(s.length());
        for (List<Integer> edge:pairs){
            unionFind.union(edge.get(0), edge.get(1));
        }

        HashMap<Integer,PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int parent=unionFind.find(i);
//            List<Character> tmp= map.getOrDefault(parent,new LinkedList<>());
//            tmp.add(s.charAt(i));
            map.computeIfAbsent(parent,key->new PriorityQueue<Character>()).offer(s.charAt(i));
        }
//        HashMap<Integer,List<Character>> mapSorted=new HashMap<>();
//        for (Map.Entry<Integer,PriorityQueue<Character>> entry: map.entrySet()){
//            List<Character> v = entry.getValue();
//            Collections.sort(v);
//            mapSorted.put(entry.getKey(), v);
//        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int parent=unionFind.find(i);
            PriorityQueue<Character> list = map.get(parent);
            sb.append(list.poll());
//            list.remove(0);
            map.put(parent, list);
        }
        return sb.toString();


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
public class q1202 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> pairs=new LinkedList<>();
        List<Integer> tmp=new LinkedList<>();
        tmp.add(0);
        tmp.add(3);
        pairs.add(tmp);
        List<Integer> tmp2=new LinkedList<>();
        tmp2.add(1);
        tmp2.add(2);
        pairs.add(tmp2);
        System.out.println(solution.smallestStringWithSwaps("dcab",pairs));
    }
}
