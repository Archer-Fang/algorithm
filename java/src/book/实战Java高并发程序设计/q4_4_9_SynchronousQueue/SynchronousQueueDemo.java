package book.实战Java高并发程序设计.q4_4_9_SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Created by Fangzj
 * @data 2021/5/18 16:15
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<Object> queue = new SynchronousQueue<>();
        new Thread(){
            @Override
            public void run() {
                queue.offer(1);
                System.out.println("put 1");
                queue.offer(2);
                System.out.println("put 2");
                queue.offer(3);
                System.out.println("put 3");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                queue.poll();
                System.out.println("get 1");
                queue.poll();
                System.out.println("get 2");
//                queue.poll();
//                System.out.println("get 3");
            }
        }.start();
    }
}
