package book.实战Java高并发程序设计.q2_2_1_NewThread;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 13:44
 **/
public class CreateThread3 implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new CreateThread3());
        thread.start();

    }
    @Override
    public void run() {
        System.out.println("hello");
    }
}
