package book.实战Java高并发程序设计.q4_3_1_ThreadLocalDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Created by Fangzj
 * @data 2021/5/17 22:11
 **/
public class ThreadLocalDemo {
    static ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal<SimpleDateFormat>();
    public static class ParseDate implements Runnable{
        int i=0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if(threadLocal.get()==null){
                threadLocal.set(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"));
            }
            try {
                Date t=threadLocal.get().parse("2021-05-17 22:16:"+i%60);
                System.out.println("thread"+i+":"+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            ParseDate parseDate = new ParseDate(i);
            threads[i]=new Thread(parseDate);
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
