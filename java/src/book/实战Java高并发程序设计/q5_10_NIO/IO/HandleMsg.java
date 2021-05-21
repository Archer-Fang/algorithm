package book.实战Java高并发程序设计.q5_10_NIO.IO;

import java.io.*;
import java.net.Socket;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 14:25
 **/
public class HandleMsg implements Runnable {
    Socket clientSocket;
    public HandleMsg(Socket clienSocket) {
        this.clientSocket=clienSocket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter printWriter= null;
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            String inputLine=null;
            long b=System.currentTimeMillis();
            while ((inputLine=reader.readLine())!=null){
                printWriter.println(inputLine);
            }
            long e=System.currentTimeMillis();
            System.out.println("spend:"+(e-b)+"ms");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null) {
                    reader.close();

                }
                if(printWriter!=null){
                    printWriter.close();
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
