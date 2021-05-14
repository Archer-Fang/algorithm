package book.book.实战Java高并发程序设计.q2_2_4_SimpleWN;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 14:35
 **/
public class SimpleWN {
    final static Object obj=new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (obj){
                System.out.println("T1 start");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end");
            }
        }
    }
    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (obj){
                System.out.println("T2 start");
                obj.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end");
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }

}
