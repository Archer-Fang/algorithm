package book.实战Java高并发程序设计.q5_10_NIO.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 14:33
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=null;
        PrintWriter printWriter=null;
        BufferedReader bufferedReader=null;
        try {
            socket=new Socket();
            socket.connect(new InetSocketAddress("localhost",8000));
            printWriter=new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("hello");
            printWriter.flush();
            bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("from serve: "+bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(printWriter!=null) printWriter.close();
            if(bufferedReader!=null) bufferedReader.close();
            if(socket!=null) socket.close();

        }
    }
}
