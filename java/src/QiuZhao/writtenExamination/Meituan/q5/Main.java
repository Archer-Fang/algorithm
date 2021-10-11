package QiuZhao.writtenExamination.Meituan.q5;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/10/10 11:26
 **/
public class Main {
    public static void main(String[] args) {
        //第一行一个整数 n，表示此有根树共有n个节点。
        //
        //第二行 n 个数，第 i 个数是a[i]，代表第 i 个节点的权值。
        //
        //第三行 n-1 个数，第 i 个数是pi+1，代表第 i+1个节点的父亲。保证为合法树结构。1≤pi＜i
        //
        //数字间两两空格隔开。
        //
        //对于100%的数据，树的节点个数n满足 1 <= n <= 100,000，节点的权值 a[i] 满足 -100,000 <= a[i] <= 100,000

        //dp[i][j]=(n*bs[i]-b)*(n*bs[i]-b)+dp[j][k1]+dp[j][k2];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();


        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] bs = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] parents = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        for (int i = 1; i <= parents.length; i++) {
            LinkedList<Integer> parent = map.getOrDefault(parents[i-1], new LinkedList<Integer>());
            parent.add(i+1);
            map.put(parents[i-1],parent);
        }
        int b= Arrays.stream(bs).sum();
        long ans=0;
        long[] dp=new long[100001];
        ans=dfs(1,map,bs,n,b,dp);
        ans=ans%1000000007;
        System.out.println(ans);
    }

    private static long dfs(int parent,HashMap<Integer, LinkedList<Integer>> map, int[] bs, int n, int b,long[] dp) {
        if(map.getOrDefault(parent, new LinkedList<Integer>()).size()==0)  {
            long tmp=(n*bs[parent-1]-b)*(n*bs[parent-1]-b);
            dp[parent]=tmp;
            return tmp;
        }
        long l=0,r=0;
        if(map.getOrDefault(parent, new LinkedList<Integer>()).size()==1){
            l=dfs(map.getOrDefault(parent, new LinkedList<Integer>()).get(0),map,bs,n,b,dp);
            dp[map.getOrDefault(parent, new LinkedList<Integer>()).get(0)]=l;
            dp[parent]=(n*bs[parent-1]-b)*(n*bs[parent-1]-b)+dp[map.getOrDefault(parent, new LinkedList<Integer>()).get(0)];
        }
        if(map.getOrDefault(parent, new LinkedList<Integer>()).size()==2){
            l=dfs(map.getOrDefault(parent, new LinkedList<Integer>()).get(0),map,bs,n,b,dp);
            dp[map.getOrDefault(parent, new LinkedList<Integer>()).get(0)]=l;
            r=dfs(map.getOrDefault(parent, new LinkedList<Integer>()).get(1),map,bs,n,b,dp);
            dp[map.getOrDefault(parent, new LinkedList<Integer>()).get(1)]=r;
            dp[parent]=(n*bs[parent-1]-b)*(n*bs[parent-1]-b)+dp[map.getOrDefault(parent, new LinkedList<Integer>()).get(0)]+dp[map.getOrDefault(parent, new LinkedList<Integer>()).get(1)];
        }
        return dp[parent];
    }


}
