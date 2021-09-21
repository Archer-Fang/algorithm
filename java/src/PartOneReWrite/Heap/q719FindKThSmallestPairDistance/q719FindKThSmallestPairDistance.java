package PartOneReWrite.Heap.q719FindKThSmallestPairDistance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

//Java：找出第 k 小的距离对
public class q719FindKThSmallestPairDistance{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        solution.smallestDistancePair(new int[]{62,100,4},2);
//        solution.smallestDistancePair(new int[]{1,6,1},3);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Item> minHeap = new PriorityQueue<>((a, b) ->  a.abs-b.abs);
        HashSet<String> visited = new HashSet<>();
        //init
        for (int i = 0; i < nums.length-1; i++) {
            int abs=nums[i+1]-nums[i];
            visited.add(Arrays.toString(new int[]{i,i+1}));
            minHeap.add(new Item(abs,new int[]{i,i+1}));
        }
        //
        Item poll=null;
        for (int i = 0; i < k; i++) {
            poll = minHeap.poll();
            for (int j = 0; j < nums.length - 1; j++) {
                int[] points = poll.points;
                points[1] += 1;
                if(points[1]<nums.length&&!visited.contains(Arrays.toString(points))){
                    int[] newPoints = Arrays.copyOf(points, points.length);
                    visited.add(Arrays.toString(newPoints));
                    int abs = poll.abs - nums[newPoints[1] - 1] + nums[newPoints[1]];
                    minHeap.add(new Item(abs,newPoints));
                }
                points[1] -= 1;
            }
        }

        return poll.abs;
    }
    class Item{
        int abs;
        int[] points;

        public Item(int abs, int[] points) {
            this.abs = abs;
            this.points = points;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
