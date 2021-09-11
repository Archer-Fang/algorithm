package ShiXi.wangyi.q3;

/**
 * @author Created by Fangzj
 * @data 2021/4/24 15:45
 **/

import java.util.*;

class Solution {
    int sum=-1;
    public void needNum(char[][] map,ArrayList point,int x,int sx,int sy) {
        LinkedList path =new LinkedList();
        List<LinkedList> paths=new LinkedList<>();
        int[] visit=new int[point.size()];
        for (int i=0;i<point.size();i++){
            Arrays.fill(visit,0);
            dfs(point,x,path,paths,0,i,visit);
        }
        int ans=-1;
        for(LinkedList tmp:paths){
//            LinkedList tmp= (LinkedList) paths.get(0);
            for (int j=0;j<x;j++){
                Point tmp2= (Point) tmp.get(j);
                map[tmp2.x][tmp2.y]='#';
            }
            int[][] vis=new int[map.length][map[0].length];
            sum=-1;
            computerShortPath(map,sx,sy,1,vis);
            ans=Math.max(ans,sum);
            for (int j=0;j<x;j++){
                Point tmp2= (Point) tmp.get(j);
                map[tmp2.x][tmp2.y]='?';
            }
        }

        System.out.println(ans);
        //一有结果直接sout
        return;
    }
    public void dfs(ArrayList point,int x,LinkedList path,List paths,int step,int k,int[] visit){
        if(step==x){
            paths.add(new LinkedList<>(path));
            return;
        }
        for (int i=k;i<point.size();i++){
            if(visit[i]!=1){
                visit[i]=1;
                path.add(point.get(i));
                dfs(point,x,path,paths,step+1,i,visit);
                path.remove(point.get(i));
//                visit[i]=0;
            }
        }

        return;
    }
    public void computerShortPath(char[][] map,int a, int b,int step,int[][] vis){
        if(map[a][b]=='T'){
            if(sum!=-1){
                sum=Math.min(sum,step);
            }else {
                sum=step;
            }

            return ;
        }
        if(a<0||b<0||a>=map.length||b>=map[0].length||map[a][b]=='#') return ;
        int[] lr={-1,1,0,0};
        int[] bt={0,0,1,-1};
        for (int i=0;i<4;i++){
            if(!(a+lr[i]<0||b+bt[i]<0||a+lr[i]>=map.length||b+bt[i]>=map[0].length)&&(vis[a+lr[i]][b+bt[i]]!=1)){
                vis[a+lr[i]][b+bt[i]]=1;
                computerShortPath(map,a+lr[i],b+bt[i],step+1,vis);
            }
        }
        return;


    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] map=new char[d1[0]][d1[1]];
        int sx=-1,sy=-1;
        for (int i=0;i<map.length;i++){
            String tmp= in.nextLine();
            for (int j=0;j<map[0].length;j++){
                map[i][j]=tmp.charAt(j);
                if(map[i][j]=='S'){
                    sx=i;
                    sy=j;
                }
            }
        }
        int k=0;
        ArrayList<Point> arrayList=new ArrayList<>();
        while (d1[2]>0){
            if(map[k/d1[1]][k%d1[1]]=='?'){
                d1[2]--;
                arrayList.add(new Point(k/d1[1],k%d1[1]));
            }
            k++;
        }
        solution.needNum(map,arrayList,d1[3],sx,sy);
//        System.out.println("1");

    }
}


//3 3 4 1
//S.?
//#??
//T?.

//3 3 4 3
//S.?
//#??
//T?.
