package PartOne.GCD.q914;

import java.util.HashMap;

/**
 * @author Created by Fangzj
 * @data 2021/3/19 14:43
 **/
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (Integer num: deck){
            map.put(num,(map.getOrDefault(num,0)+1));
        }
        return map.values().stream().reduce((a,b)->gcd(a,b)).get()>1?true:false;

    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
public class q914 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
    }
}
