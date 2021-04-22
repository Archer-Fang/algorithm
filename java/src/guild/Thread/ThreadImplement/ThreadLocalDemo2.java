package guild.Thread.ThreadImplement;

/**
 * @author Created by Fangzj
 * @data 2021/4/20 11:17
 **/
public class ThreadLocalDemo2 {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                threadLocal.set("zhazha" + Thread.currentThread().getName());
                String s = threadLocal.get();
                System.out.println("threadName = " + Thread.currentThread().getName()  + " [ threadLocal = "  + threadLocal + "\t data = " + s + " ]");
            }, "threadName" + i).start();
        }
    }
}
