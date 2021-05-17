package book.实战Java高并发程序设计.q3_3_4_ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Created by Fangzj
 * @data 2021/5/17 20:31
 **/
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
//        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
//        queue.offer(1);
//        queue.offer(2);
//        for (ConcurrentLinkedQueue.Node<E> t = tail, p = t;;) {
//            ConcurrentLinkedQueue.Node<E> q = p.next;
//            if (q == null) {插入第二个节点 第二轮循环 直接插入
//                // p is last node
//                if (p.casNext(null, newNode)) {
//
//                    if (p != t) // hop two nodes at a time
//                        casTail(t, newNode);  // Failure is OK.
//                    return true;
//                }
//            }
//            else if (p == q)
//
//                p = (
//                t != (t = tail)//跟多个线程有竞争导致的，如果t对应的tail不是最新的，则移到最新的tail，重新插入，否则从头再来。
//                ) ? t : head;
//            else
//                p = (
//                        p != t//插入第二个节点，第一轮 p=q;
//                        &&
//                        t != (t = tail)//用于防止多个线程竞争导致t所索引的tail不是最新的
//                ) ? t : q;
//        }
        ConcurrentLinkedQueue queue2 = new ConcurrentLinkedQueue();
        queue2.offer(1);
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
    }
}
