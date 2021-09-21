package PartOneReWrite.Heap.q295FindMedianFromDataStream;

import java.util.PriorityQueue;

//Java：数据流的中位数
public class q295FindMedianFromDataStream{
    public static void main(String[] args) {
//        Solution solution = new Solution();
        // TO TEST
        //["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        //[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);//1
        System.out.println(obj.findMedian());
        obj.addNum(2);//2
        System.out.println(obj.findMedian());
        obj.addNum(3);//2
        System.out.println(obj.findMedian());
        obj.addNum(4);//3
        System.out.println(obj.findMedian());
        obj.addNum(5);//3
        System.out.println(obj.findMedian());
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    int count=0;
    /** initialize your data structure here. */
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        count++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()+1) maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        if(count%2==1) return minHeap.peek();
        return ((double)(minHeap.peek()+maxHeap.peek()))/2;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
