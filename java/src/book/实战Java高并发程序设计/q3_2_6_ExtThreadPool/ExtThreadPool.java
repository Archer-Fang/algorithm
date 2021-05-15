package book.实战Java高并发程序设计.q3_2_6_ExtThreadPool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by Fangzj
 * @data 2021/5/15 15:49
 **/

public class ExtThreadPool {
    public static class MyTask implements Runnable{
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5)){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
//                System.out.println("ready exec: "+((MyTask)r).getName());
                System.out.println("ready exec: ");
            }
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
//                System.out.println("over exec: "+((MyTask) r).name);
                System.out.println("over exec: ");
            }
            @Override
            protected void terminated() {
                System.out.println("ok~");
            }
        };
        for (int i = 0; i <5; i++) {
            MyTask task = new MyTask("TASK-" + i);
            threadPoolExecutor.submit(task);
        }
        threadPoolExecutor.shutdown();
    }
}
