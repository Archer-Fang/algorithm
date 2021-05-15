package book.实战Java高并发程序设计.q2_4_ThreadSafeAndSyn;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 15:30
 **/
public class ThreadSafeAndSyn  {
    static int i=0;
    public static class AddNum implements Runnable{
        public synchronized void increse(){
            i++;
        }
        @Override
        public void run() {
            for (int j = 0; j < 10000000; j++) {
                increse();
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
