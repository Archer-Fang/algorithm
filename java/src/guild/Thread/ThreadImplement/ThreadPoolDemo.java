package guild.Thread.ThreadImplement;

import java.util.concurrent.*;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 20:28
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        ExecutorService executors=  Executors.newFixedThreadPool(5);
        for (int i=0;i<10;i++){
            executors.execute(new Task(i));
        }
    }
}
class Task implements Runnable {
    private int i;
    public Task(int i) {
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println("Thread"+this.i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
