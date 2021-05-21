package book.实战Java高并发程序设计.q5_10_NIO.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 14:33
 **/
public class ClientHeavy {
    public static class EchoClient implements Runnable{
        @Override
        public void run() {
            Socket socket=null;
            PrintWriter printWriter=null;
            BufferedReader bufferedReader=null;
            try {
                socket=new Socket();
                socket.connect(new InetSocketAddress("localhost",8000));
                printWriter=new PrintWriter(socket.getOutputStream(),true);
                printWriter.println("hello");
                Thread.sleep(3000);
                printWriter.flush();
                bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("from serve: "+bufferedReader.readLine());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(printWriter!=null) printWriter.close();
                    if(bufferedReader!=null) bufferedReader.close();
                    if(socket!=null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executorService.execute(new EchoClient());
        }

    }
}
