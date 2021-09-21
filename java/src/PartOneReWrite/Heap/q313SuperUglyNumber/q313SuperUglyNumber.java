package PartOneReWrite.Heap.q313SuperUglyNumber;

import java.util.PriorityQueue;

//Java：超级丑数
public class q313SuperUglyNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.nthSuperUglyNumber(30,new int[]{
                3,5,13,19,23,31,37,43,47,53}));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);
        long poll =-1;
        for (int i = 0; i < n; i++) {
            poll = minHeap.poll();
            for (int j = 0; j < primes.length; j++) {
                long prime = primes[j]*poll;
                minHeap.add(prime);
            }
            while (!minHeap.isEmpty()&&minHeap.peek()==poll){
                minHeap.poll();
            }
        }
        return Math.toIntExact(poll);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
