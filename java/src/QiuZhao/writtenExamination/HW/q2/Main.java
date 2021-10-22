package QiuZhao.writtenExamination.HW.q2;

import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/20 18:57
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        String s = in.nextLine().replace("[","").replaceAll("]","");
        String[] nums = s.split(",");
        int M=nums.length/2+1;
        int[][] map = new int[1001][1001];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j]=10000;
            }
        }

        int k1=0;
        while (k1<nums.length){
            map[Integer.parseInt(nums[k1])-1][Integer.parseInt(nums[k1+1])-1]=1;
            map[Integer.parseInt(nums[k1+1])-1][Integer.parseInt(nums[k1])-1]=1;
            k1=k1+2;
        }
//        for (int k = 1; k < M; k++) {
//            for (int i = 1; i < M; i++) {
//                for (int j = 1; j < M; j++) {
//                    if(map[i][k]==Long.MAX_VALUE||map[k][j]==Long.MAX_VALUE) continue;
//                    if(map[i][k]+map[k][j]<map[i][j]) {
//                        map[i][j]=map[i][k]+map[k][j];
//                    }
//                }
//            }
//        }
//        String ans="";
//        int max=0;
//        for (int i = 1; i < M; i++) {
//            if(map[n][i]==Long.MAX_VALUE) continue;
//            if(map[n][i]>max) ans=i+" "+map[n][i];
//        }
//        System.out.println(ans);
        System.out.println(Dijsk(map,n-1,M-1));

    }

    private static String Dijsk(int[][] map, int start, int length) {
        int[] shortPath = new int[length];
        shortPath[0]=0;
        String[] path = new String[length];
        for (int i = 0; i < length; i++) {
            path[i]=start+"->"+i;
        }
        int[] visited = new int[length];
        visited[0]=1;
        for (int count = 1; count < length; count++) {
            int k=-1;
            int dmin=10000;
            for (int i = 0; i < length; i++) {
                if(visited[i]==0&&map[start][i]<dmin){
                    dmin=map[start][i];
                    k=i;
                }
            }
            if(k==-1) break;
            shortPath[k]=dmin;
            visited[k]=1;
            for (int i = 0; i < length; i++) {
                if(visited[i]==0&&map[start][k]+map[k][i]<map[start][i]){
                    map[start][i]=map[start][k]+map[k][i];
                    path[i]=path[k]+"->"+i;
                }
            }
        }
        int max=0;
        String ans="";
        for (int i = 0; i < length; i++) {
            if(shortPath[i]>max){
                int tmp=i+1;
                ans=tmp+" "+shortPath[i];
            }
//            System.out.println(start+" "+i+" "+path[i]+" ="+shortPath[i]);
        }


        return ans;
    }
}
