package book.实战Java高并发程序设计.q2_8_2_UnSafeArrayList;

import java.util.ArrayList;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 15:47
 **/
public class q2_8_2_UnSafeArrayList {
    static ArrayList<Integer> a1 = new ArrayList<Integer>(10);
    public static class AddNum implements Runnable{
        public synchronized void add(int i){
            a1.add(i);
        }
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                add(i);
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
        System.out.println(a1.size());
    }
}
