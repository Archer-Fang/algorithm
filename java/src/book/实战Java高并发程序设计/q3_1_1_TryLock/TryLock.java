package book.实战Java高并发程序设计.q3_1_1_TryLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by Fangzj
 * @data 2021/5/14 20:30
 **/
public class TryLock implements Runnable {
    public static ReentrantLock lock1=new ReentrantLock();
    public static ReentrantLock lock2=new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if(lock==1){
            while (true){
                if(lock1.tryLock()){
                    try {
                        Thread.sleep(5);
                        if(lock2.tryLock()){//tryLock允许设置线程获取锁的超时时间,如,允许设置线程获取锁的超时时间,如
                            try {
                                System.out.println(Thread.currentThread().getId());
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock1.unlock();
                    }
                }
            } //如果先park，后unpark。正常。 如果先unpark后park，
        }else {
            while (true){
                if(lock2.tryLock()){
                    try {
                        Thread.sleep(5);
                        if(lock1.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getId());
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }else {
                            System.out.println("fail");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TryLock tryLock = new TryLock(1);
        TryLock tryLock2 = new TryLock(2);
        Thread thread = new Thread(tryLock);
        Thread thread2 = new Thread(tryLock2);
        thread.start();thread2.start();thread.join();thread2.join();


    }
}
