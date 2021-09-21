package PartOneReWrite.Heap.q1488AvoidFloodInTheCity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

//Java：避免洪水泛滥
public class q1488AvoidFloodInTheCity{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
//        solution.avoidFlood(new int[]{1,2,0,0,2,1});
//        solution.avoidFlood(new int[]{1,2,0,1,2});
//        solution.avoidFlood(new int[]{69,0,0,0,69});
        solution.avoidFlood(new int[]{1,2,0,1,2});
//        solution.avoidFlood(new int[]{0,1,1});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans,1);
        TreeSet<Integer> sunny = new TreeSet<>();
        HashMap<Integer, Integer> wet = new HashMap<>();

        for (int i = 0; i < rains.length; i++) {
            if(rains[i]==0) {sunny.add(i);ans[i]=1;}
            else {
                if(wet.getOrDefault(rains[i],-1)!=-1) {
                    Integer t = wet.get(rains[i]);
                    Integer higher = sunny.higher(t);
                    if(higher==null) return new int[]{};
                    sunny.remove(higher);
                    ans[higher]=rains[i];
                }
                wet.put(rains[i],i);
                ans[i]=-1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
