package book.实战Java高并发程序设计.q4_4_7_AtomicIntegerFieldUpdate;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Created by Fangzj
 * @data 2021/5/18 15:46
 **/
public class AtomicIntegerFieldUpdateDemo {

    public static class Candidate{
        int id;
        volatile int scores;
    }


    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Candidate> score = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "scores");
        Candidate candidate = new Candidate();
        AtomicInteger allScore = new AtomicInteger(0);
        Thread[] threads=new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i]=new Thread(){
                @Override
                public void run() {
                    if(Math.random()>0.4){
                        score.incrementAndGet(candidate);
                        allScore.incrementAndGet();
                    }
                }
            };
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
        System.out.println(candidate.scores);
        System.out.println(allScore.get());

    }

}
