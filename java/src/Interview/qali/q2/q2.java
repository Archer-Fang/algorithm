package Interview.qali.q2;

/**
 * @author Created by Fangzj
 * @data 2021/3/29 19:03
 **/
class Solution{
    public int getN(int n,int distanceThreshold,int[][] e){
        //Floyd
        int[][] distance=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i=0;i<e.length;i++){
            distance[e[i][0]][e[i][1]]=e[i][2];
//            distance[e[i][1]][e[i][0]]=e[i][2];
        }
        for(int i=0;i<n;i++){
            distance[i][i]=0;
        }
        for(int k=0;k<n;k++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if(i!=k&&j!=k&&distance[i][k]!=Integer.MAX_VALUE&&distance[k][j]!=Integer.MAX_VALUE){
                        distance[i][j]=Math.min((distance[i][k]+distance[k][j]),distance[i][j]);
                    }

                }
            }
        }
        int min=Integer.MAX_VALUE;
        int c=0;
        int ans=-1;
        for (int i=0;i<n;i++){
            c=0;
            for (int j=0;j<n;j++){
                if(i!=j&&distance[i][j]<distanceThreshold){
                    c++;
                }

            }
            //编号最大
            if(c<=min){
                ans=i;
                min=c;
            }
        }
        return ans;
    }

}
public class q2 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.getN(4,4,new int[][]{{0,1,3},{1,2,1},{2,3,1},{1,3,4}}));

    }
}
