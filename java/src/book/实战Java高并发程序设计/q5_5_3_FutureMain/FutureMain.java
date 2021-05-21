package book.实战Java高并发程序设计.q5_5_3_FutureMain;

import java.util.concurrent.*;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 14:08
 **/
public class FutureMain {
    static class RealData implements Callable<String>{
        private String data;

        public RealData(String data) {
            this.data = data;
        }

        @Override
        public String call() throws Exception {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                stringBuffer.append(data);
                Thread.sleep(100);
            }
            return stringBuffer.toString();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> a = new FutureTask<>(new RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(a);
        System.out.println("finish request");
        Thread.sleep(2000);
        System.out.println(a.get());
    }
}
