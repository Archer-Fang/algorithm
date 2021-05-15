package book.实战Java高并发程序设计.q3_1_1_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by Fangzj
 * @data 2021/5/14 20:14
 **/
public class q3_1_1_ReentrantLock {
    static int i=0;
    public static ReentrantLock reentrantLock=new ReentrantLock();
    public static class AddNum implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 10000000; j++) {
                reentrantLock.lock();
                try {
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddNum addNum = new AddNum();
        Thread t1 = new Thread(addNum);
        Thread t2 = new Thread(addNum);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}
