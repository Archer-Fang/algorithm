package PartOne.UnionFind.q721;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/20 19:18
 **/
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map=new HashMap<>();//email->id
        HashMap<String,String> map2=new HashMap<>();//email->name
        int emailCount=0;
        for (int i=0;i<accounts.size();i++){
            String name= accounts.get(i).get(0);
            for (int j=1;j<accounts.get(i).size();j++){
                map2.put(accounts.get(i).get(j),name);
                map.put(accounts.get(i).get(j),emailCount++);
            }
        }
        UnionFind unionFind=new UnionFind(emailCount);
        //账号合并
        for (int i=0;i<accounts.size();i++){
            int mail=map.get(accounts.get(i).get(1));
            for (int j=1;j<accounts.get(i).size();j++){
                unionFind.union(map.get(accounts.get(i).get(j)),mail);
            }
        }
        //搜索并查集,根据统一父节点
        HashMap<Integer,List<String>> map3=new HashMap<>();
        for(String email:map.keySet()){
            int parent=unionFind.find(map.get(email));
            List<String> tmp=map3.getOrDefault(parent,new LinkedList<>());
            tmp.add(email);
            map3.put(parent,tmp);
        }

        List<List<String>> rs2=new LinkedList<>();
        for(List<String> mails:map3.values()){
            List<String> tmp=new LinkedList<>();
            tmp.add(map2.get(mails.get(0)));//添加名字
            Collections.sort(mails);
            tmp.addAll(mails);//添加邮箱
            rs2.add(tmp);

        }
        return rs2;

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
public class q721 {
    public static void main(String[] args) {
        Solution solution=new Solution();

    }
}
