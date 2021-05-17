package book.实战Java高并发程序设计.q4_1_4_LinkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Created by Fangzj
 * @data 2021/5/17 22:02
 **/
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.add(1);
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
