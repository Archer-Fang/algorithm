package book.实战Java高并发程序设计.q5_10_NIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 16:05
 **/
public class NIOClient {
    public Selector selector;
    public void init(int port) throws IOException {
        selector= SelectorProvider.provider().openSelector();
        SocketChannel channel=SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress(port));
        channel.register(selector, SelectionKey.OP_CONNECT);

    }
    public void working() throws IOException, InterruptedException {
        while (true){
            if(!selector.isOpen()){
                break;
            }
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();
                if(next.isConnectable()){
                    connect(next);
                }else if(next.isReadable()){
                    read(next);
                }
            }
        }
    }

    private void read(SelectionKey next) throws IOException {
        SocketChannel channel = (SocketChannel) next.channel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        channel.read(buffer);
        byte[] array = buffer.array();
        String msg = new String(array).trim();
        System.out.println("clien receive:"+msg);
        channel.close();
        next.selector().close();


    }

    private void connect(SelectionKey next) throws IOException, InterruptedException {
        SocketChannel channel = (SocketChannel) next.channel();
        if(channel.isConnectionPending()){
            channel.finishConnect();
        }
        channel.configureBlocking(false);
        channel.write(ByteBuffer.wrap(new String("hello serve").getBytes()));
        Thread.sleep(3000);
        channel.register(selector,SelectionKey.OP_READ);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            NIOClient client = new NIOClient();
            client.init(8000);
            client.working();
        }
//        NIOClient client = new NIOClient();
//        client.init(8000);
//        client.working();

    }

}
