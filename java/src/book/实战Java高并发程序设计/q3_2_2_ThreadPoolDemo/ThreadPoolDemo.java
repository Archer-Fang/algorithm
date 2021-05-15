package book.实战Java高并发程序设计.q3_2_2_ThreadPoolDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by Fangzj
 * @data 2021/5/15 15:07
 **/
public class ThreadPoolDemo {
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
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Task task = new Task();
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }
}
