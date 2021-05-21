package book.实战Java高并发程序设计.q5_10_NIO.IO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 14:21
 **/
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket clienSocket=null;
        while (true){
            clienSocket=serverSocket.accept();
            System.out.println(clienSocket.getRemoteSocketAddress()+" connect!");
            executorService.execute(new HandleMsg(clienSocket));
        }

    }
}
