package guild.Thread.ThreadImplement;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Created by Fangzj
 * @data 2021/4/15 20:59
 **/
public class qali {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger j = new AtomicInteger(0);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                j.incrementAndGet();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 9999; i++) {
                j.incrementAndGet();
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                j.decrementAndGet();
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                j.decrementAndGet();
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(j);
    }
}
