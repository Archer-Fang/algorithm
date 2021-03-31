package PartOne.DFS.q401;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/13 22:48
 **/
class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hours={1,2,4,8,0,0,0,0,0,0};
        int[] minites={0,0,0,0,1,2,4,8,16,32};
        List<String> ans=new LinkedList<>();

        dfs(hours,minites,num,ans,0,0,0);
        return ans;
    }
    public void dfs(int[] hours,int[] minites,int num,List<String> ans,int curHous,int curMinite,int index){
        if(curHous>11||curMinite>59) return ;

        if(num==0) {
            if(curMinite<10){
                ans.add(curHous+":0"+curMinite);
            }else{
                ans.add(curHous+":"+curMinite);
            }
            return;
        }
        --num;
        for(int i=index;i<10;i++){
            dfs(hours,minites,num,ans,curHous+hours[i],curMinite+minites[i],i+1);
        }
        return ;
    }
}
public class q401 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.readBinaryWatch(2));
    }
}
