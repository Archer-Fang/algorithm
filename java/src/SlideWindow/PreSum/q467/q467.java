package SlideWindow.PreSum.q467;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/3/16 14:58
 **/
class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p.length()<2) return p.length();
        char[] P=p.toCharArray();
        int pre=1;
        int ans=1;
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        map.put(P[0],Math.max(map.getOrDefault(P[0],1),ans));
        for (int i=1;i<P.length;i++){
            if(P[i]-P[i-1]==1||P[i]-P[i-1]==-25) pre++;
            else pre=1;
            map.put(P[i],Math.max(map.getOrDefault(P[i],0),pre));
        }
        int sum=0;
        for(Integer i:map.values()){
            sum+=i;
        }
        return sum;
    }
}
public class q467 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findSubstringInWraproundString("zab"));
    }
}


//        {z:1,a:2,b:3}