package Interview.qali;

/**
 * @author Created by Fangzj
 * @data 2021/3/29 11:15
 **/
class Solution {
    public int minFlips(int[] a) {
        int sum=0;
        int[] ans=new int[a.length];
        if(a[0]==1) ans[0]=1;
        for (int i=1;i<a.length;i++){
            if(a[i]==1){
                sum++;
                ans[i]=ans[i-1]+1;
            }
        }
        if(sum==a.length-1) return sum;
        sum=0;
        int sum1=0;
        int sum2=0;
        for (int i=0;i<ans.length;i++){
            if(ans[i]!=0){
                sum1=ans[i];
            }
            else {
                sum2=fromIndexFindMax(ans,i+1);
            }
            sum=Math.max(sum,(sum1+sum2));
        }
        return sum;
    }
    public int fromIndexFindMax(int[] ans,int index){
        int sum2=0;
        for (int i=index;i<ans.length;i++){
            if(ans[i]!=0){
                sum2=ans[i];
            }else {break;}
        }
        return sum2;
    }
}
public class qali {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minFlips(new int[]{1,1,1}));
        System.out.println(solution.minFlips(new int[]{1,1,0,1,0,1}));
    }
}
