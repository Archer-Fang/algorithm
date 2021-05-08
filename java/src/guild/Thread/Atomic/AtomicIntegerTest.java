package guild.Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Created by Fangzj
 * @data 2021/5/6 16:10
 **/
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(0);
        atomicInteger.compareAndSet(0,1);
        atomicInteger.compareAndSet(0,2);
        System.out.println(atomicInteger.get());
    }
}
