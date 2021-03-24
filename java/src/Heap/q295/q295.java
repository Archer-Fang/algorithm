package Heap.q295;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Created by Fangzj
 * @data 2021/3/23 10:32
 **/
class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size()) return (maxHeap.peek()+minHeap.peek())/2.0;
        else{
            return maxHeap.peek();
        }

    }
}
public class q295 {
    public static void main(String[] args) {
        MedianFinder solution=new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(3);
        System.out.println(solution.findMedian());

    }
}
