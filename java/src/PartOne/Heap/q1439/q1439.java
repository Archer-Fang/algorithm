package PartOne.Heap.q1439;

import java.util.*;

/**
 * @author Created by Fangzj
 * @data 2021/3/23 11:10
 **/
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) sum += mat[i][0];

        PriorityQueue<Item> pq = new PriorityQueue<>( (o1, o2) -> o1.total - o2.total );

        Set<String> visit = new HashSet<>();
        Item first = new Item(new int[mat.length], sum);
        visit.add(Arrays.toString(first.pick));
        pq.offer(first);

        while (k > 1) {
            Item item = pq.poll();
            k--;
            for (int i = 0; i < mat.length; i++) {
                item.pick[i]++;

                if (item.pick[i] < mat[i].length && !visit.contains(Arrays.toString(item.pick))) {
                    visit.add(Arrays.toString(item.pick));
                    int[] pick = Arrays.copyOf(item.pick, item.pick.length);

                    int total = item.total - mat[i][item.pick[i] - 1] + mat[i][item.pick[i]];
                    pq.add(new Item(pick, total));
                }

                item.pick[i]--;
            }

        }

        return pq.peek().total;

    }
    private class Item {
        private int[] pick;
        private int total;

        public Item(int[] pick, int total) {
            this.pick = pick;
            this.total = total;
        }
    }

}
public class q1439 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.kthSmallest( new int[][]{{1,3,11},{2,4,6}},5 ));
    }
}
