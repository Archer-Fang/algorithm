package ShiXi.wangyi.q3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/4/24 17:37
 **/
public class Main2 {
    static boolean[][] vis;
    static char[][] maps;
    static int[][] moves={{1,0},{0,1},{-1,0},{0,-1}};
    static int R,C,Y,X;
    static int[] des;
    static int[] records;
    static boolean[] v;
    static int max=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        R=scanner.nextInt();
        C=scanner.nextInt();
        Y=scanner.nextInt();
        X=scanner.nextInt();

        records=new int[Y];
        v=new boolean[Y];
        des=new int[X];

        maps=new char[R][C];
        vis=new boolean[R][C];
        scanner.nextLine();
        int index=0;
        for(int i=0;i<R;i++){
            String s=scanner.nextLine();
            for (int j=0;j<C;j++){
                char ch=s.charAt(j);
                if(ch=='?'){
                    records[index++]=i*R+j;
                }
                maps[i][j]=ch;
            }
        }
        process(0);
        if(max==0) max=-1;
        System.out.println(max);
    }
    private static void process(int k){
        if(k==X){
            HashSet<Integer> set=new HashSet<>();
            for (int i=0;i<X;i++){
                set.add(des[i]);
            }
            int ans=Integer.MAX_VALUE;
            Iterator<Integer> iterator=set.iterator();
            char[][] temp=new char[R][C];
            for (int i = 0; i <R ; i++) {
                for (int j = 0; j <C ; j++) {
                    temp[i][j]=maps[i][j];
                    vis[i][j]=false;
                }
            }
            while (iterator.hasNext()){
                Integer n=iterator.next();
                temp[n/C][n%R]='#';
            }
            for (int i = 0; i <R ; i++) {
                for (int j = 0; j <C ; j++) {
                    if(temp[i][j]=='S'){
                        vis[i][j]=true;
                        dfs(ans,temp,i,j,1);
                    }
                }

            }
            return;
        }
        for (int i=0;i<records.length;i++){
            if(!v[i]){
                v[i]=true;
                des[k]=records[i];
                process(k+1);
                v[i]=false;
            }
        }

    }
    private static void dfs(int ans,char[][] temp,int x,int y,int steps){
        if(temp[x][y]=='T'){
            ans=Math.min(ans,steps);
            max=Math.max(ans,max);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x1=x+moves[k][0];
            int y1=y+moves[k][1];
            if(x1<0||y1<0||x1>R-1||y1>C-1||temp[x1][y1]=='#'||vis[x1][y1]) continue;
            vis[x1][y1]=true;
            dfs(ans, temp, x1, y1, steps+1);
            vis[x1][y1]=false;

        }
    }
}
//3 3 4 1
//S.?
//#??
//T?.