package book.实战Java高并发程序设计.q4_4_5_AtomicStampReference;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Created by Fangzj
 * @data 2021/5/18 15:25
 **/
public class AtomicStampReferenceDemo {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);
        for (int i = 0; i < 3; i++) {
            final int timestamp=money.getStamp();
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m = money.getReference();
                            if(m<20){
                                if(money.compareAndSet(m,m+20,timestamp,timestamp+1)){
                                    System.out.println("money<20,add 20");
                                }
                            }
                            else {
                                System.out.println("no need to add");
                            }
                        }
                    }
                }
            }.start();
        }
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1; i++) {
                    while (true){
                        Integer m=money.getReference();
                        Integer timeStamp=money.getStamp();
                        if(m>10){
                            if(money.compareAndSet(m,m-10,timeStamp,timeStamp+1)){
                                System.out.println("money>10, consume 10");
                            }
                        }else {
                            System.out.println("not enough money");
                        }
                    }
                }
            }
        }.start();
    }

}
