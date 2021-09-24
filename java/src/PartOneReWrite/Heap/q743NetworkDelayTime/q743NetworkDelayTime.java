package PartOneReWrite.Heap.q743NetworkDelayTime;

import java.util.*;

//Java：网络延迟时间
public class q743NetworkDelayTime{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1},{2,3,2},{1,3,4}},3,1));;//-1
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            List<int[]> list = map.getOrDefault(time[0], new LinkedList<>());
            list.add(new int[]{time[1], time[2]});
            map.put(time[0],list);
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        djks(map,k,count);
        Integer max = count.values().stream().max(Integer::compareTo).get();
        if(count.values().size()!=n) max=0;
        return max==0?-1:max;

    }

    private void djks(HashMap<Integer, List<int[]>> map, int k, HashMap<Integer, Integer> count) {
        //0:node 1:cost
        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        queue.add(new int[]{k,0});
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if(set.contains(poll[0])) continue;
            count.put(poll[0], poll[1]);
            set.add(poll[0]);

            List<int[]> nearNodes = map.getOrDefault(poll[0],new LinkedList<>());
            for (int[] nearNode : nearNodes) {
                queue.add(new int[]{nearNode[0],nearNode[1]+poll[1]});
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
