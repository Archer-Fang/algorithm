package book.实战Java高并发程序设计.q3_2_4_RejectThreadPoolDemo;

import java.util.concurrent.*;

/**
 * @author Created by Fangzj
 * @data 2021/5/15 15:28
 **/
public class RejectThreadPoolDemo {
    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5)
                , new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r + " is discard");
            }
        });
        for (int i = 0; i <15; i++) {
            threadPoolExecutor.submit(task);
        }
    }
}
