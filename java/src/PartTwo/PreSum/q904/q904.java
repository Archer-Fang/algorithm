package PartTwo.PreSum.q904;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/3/31 19:42
 **/
class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=-1;
        int L=0;
        for (int i=0;i<tree.length;i++){
            map.put(tree[i],map.getOrDefault(tree[i],0)+1);
            while (map.size()>2){
                map.put(tree[L],map.getOrDefault(tree[L],0)-1);
                if(map.get(tree[L])==0) map.remove(tree[L]);
                L++;
            }
            ans=Math.max(ans,i-L+1);
        }
        return ans;
    }
}
public class q904 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.totalFruit(new int[]{1,2,1}));
        System.out.println(solution.totalFruit(new int[]{0,1,2,2}));
        System.out.println(solution.totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
