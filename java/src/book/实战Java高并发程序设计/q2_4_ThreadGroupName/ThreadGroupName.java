package book.实战Java高并发程序设计.q2_4_ThreadGroupName;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 15:11
 **/
public class ThreadGroupName implements Runnable{


    public static void main(String[] args) {
        ThreadGroup printGroup = new ThreadGroup("PrintGroup");
        Thread t2 = new Thread(printGroup, new ThreadGroupName(), "T2");
        Thread t1 = new Thread(printGroup, new ThreadGroupName(), "T1");
        t1.start();
        t2.start();
        System.out.println(printGroup.activeCount());
        printGroup.list();


    }
    @Override
    public void run() {
        String groupAndName=Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
        while (true){
            System.out.println(groupAndName);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
