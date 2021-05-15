package book.实战Java高并发程序设计.q2_2_3_InterThread;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 14:10
 **/
public class InterThread  extends Thread{
    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("break");
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {//中断标志位被清除
                Thread.currentThread().interrupt();//设置中断标志位
                e.printStackTrace();
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterThread t = new InterThread();
        t.start();
        t.sleep(200);
        t.interrupt();
    }

}
