package PartOneReWrite.Heap.q787CheapestFlightsWithinKStops;

import java.util.*;

//Java：K 站中转内最便宜的航班
public class q787CheapestFlightsWithinKStops{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        //6
        System.out.println(solution.findCheapestPrice(4,new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}},0,3,1));
        //-1
        System.out.println(solution.findCheapestPrice(5,new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}},2,1,1));

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //int[0]:to int[1]:price
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            List list = map.getOrDefault(flight[0], new LinkedList());
            list.add(new int[]{flight[1],flight[2]});
            map.put(flight[0],list);
        }
        return djks(map,src,dst,k);
    }

    private int djks(HashMap<Integer, List<int[]>> map, int src, int dst,int k) {
        //int[0] to int[1] price  int[2] frequent
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{src,0,-1});
        HashSet<String> set = new HashSet<>();
        while (!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            if(set.contains(Arrays.toString(new int[]{poll[0],poll[2]}))||poll[2]>k) continue;
            set.add(Arrays.toString(new int[]{poll[0],poll[2]}));
            if(poll[0]==dst) {
                return poll[1];
            }
            List<int[]> nearNodes = map.getOrDefault(poll[0], new LinkedList<>());
            for (int[] nearNode : nearNodes) {
                minHeap.add(new int[]{nearNode[0],nearNode[1]+poll[1],poll[2]+1});
            }

        }
        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
