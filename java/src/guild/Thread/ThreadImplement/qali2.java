package guild.Thread.ThreadImplement;

/**
 * @author Created by Fangzj
 * @data 2021/4/15 20:59
 **/

public class qali2 {

    public static int j = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new ThreadTest_1();
        Thread t2=new ThreadTest_2();
        Thread t3=new ThreadTest_3();
        Thread t4=new ThreadTest_4();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println(j);
    }

    public synchronized void deleteOne(){
        j --;
    }

    public synchronized void addOne(){
        j ++;
    }
}
class ThreadTest_1 extends Thread {

    @Override
    public void run() {
        qali2 aTest = new qali2();
        for (int i = 0; i < 5; i++) {
            aTest.deleteOne();
        }
    }
}
class ThreadTest_2 extends Thread {

    @Override
    public void run() {
        new qali2().deleteOne();
    }
}
class ThreadTest_3 extends Thread {

    @Override
    public void run() {
        new qali2().addOne();
    }
}
class ThreadTest_4 extends Thread {

    @Override
    public void run() {
        new qali2().addOne();
    }
}