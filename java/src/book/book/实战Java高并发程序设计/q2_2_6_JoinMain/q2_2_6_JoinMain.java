package book.book.实战Java高并发程序设计.q2_2_6_JoinMain;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 14:55
 **/
public class q2_2_6_JoinMain {
    public volatile static int i=0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for ( i = 0; i < 10000; i++) {

            }
        }
    }

    public static void main(String[] args) {
        AddThread addThread = new AddThread();
        addThread.start();
        System.out.println(i);
    }

}
