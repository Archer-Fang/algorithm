package book.实战Java高并发程序设计.q5_10_NIO.NIO;

import java.io.BufferedReader;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 15:45
 **/
public class HandleMsg implements Runnable {
    SelectionKey next;
    ByteBuffer buffer;
    Selector selector;
    public HandleMsg() {
    }
    public HandleMsg(SelectionKey next, ByteBuffer buffer, Selector selector) {
        this.next=next;
        this.buffer=buffer;
        this.selector=selector;

    }
    @Override
    public void run() {
        NIOServer.EchoClient attachment = (NIOServer.EchoClient) next.attachment();
//        ByteBuffer wrap = ByteBuffer.wrap(new String("123").getBytes());
        attachment.enqueue(buffer);
        next.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
        selector.wakeup();
    }


}
