package book.实战Java高并发程序设计.q5_10_NIO.NIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by Fangzj
 * @data 2021/5/20 15:13
 **/
public class NIOServer {
    Selector selector=null;
    ExecutorService executorService = Executors.newCachedThreadPool();
    HashMap<Socket, Long> map = new HashMap<>(10240);
    public void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
        channel.socket().bind(inetSocketAddress);
        SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();
                if(next.isAcceptable()){
                    doAccept(next);
                }else if(next.isValid()&&next.isReadable()){
                    if(!map.containsKey(((SocketChannel) next.channel()).socket())){
                        map.put(((SocketChannel) next.channel()).socket(),System.currentTimeMillis());
                    }
                    doRead(next);
                }else if(next.isValid()&&next.isWritable()){
                    doWrite(next);
                    System.out.println("spend:"+(System.currentTimeMillis()-map.remove(((SocketChannel) next.channel()).socket()))+"ms");
                }
            }
        }
    }
    public void disconnect(SelectionKey next) {
        next.cancel();
    }
    private void doWrite(SelectionKey next) {
        SocketChannel channel = (SocketChannel) next.channel();
        EchoClient attachment = (EchoClient) next.attachment();
        LinkedList<ByteBuffer> queue = attachment.getQueue();
        ByteBuffer last = queue.getLast();
        try{
            int len = channel.write(last);
            if(len==-1){
                disconnect(next);
                return;
            }
            if(last.remaining()==0){
                queue.removeLast();
            }
        } catch (IOException e) {
            System.out.println("write fail");
            e.printStackTrace();
            disconnect(next);
        }
        if(queue.size()==0){
            next.interestOps(SelectionKey.OP_READ);
        }
    }

    private void doRead(SelectionKey next)  {
        SocketChannel channel = (SocketChannel) next.channel();
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        int len = 0;
        try {
            len = channel.read(buffer);
            if(len<0){
                disconnect(next);
                return;
            }
        } catch (IOException e) {
            System.out.println("failed to read");
            e.printStackTrace();
            disconnect(next);
            return;

        }
        buffer.flip();
        executorService.execute(new HandleMsg(next,buffer,selector));
    }

    public static class EchoClient {
        LinkedList<ByteBuffer> queue;

        public EchoClient() {
            this.queue = new LinkedList<>();
        }

        public LinkedList<ByteBuffer> getQueue() {
            return queue;
        }
        public void enqueue(ByteBuffer bb){
            queue.addFirst(bb);
        }
    }
    private void doAccept(SelectionKey next) {
        ServerSocketChannel channel = (ServerSocketChannel) next.channel();
        SocketChannel socketChannel;
        try {
            socketChannel = channel.accept();
            socketChannel.configureBlocking(false);
            SelectionKey clientKey = socketChannel.register(selector, SelectionKey.OP_READ);
            EchoClient echoClient = new EchoClient();
            clientKey.attach(echoClient);
            InetAddress inetAddress = socketChannel.socket().getInetAddress();
            System.out.println("connect from:"+inetAddress.getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        NIOServer nioServer = new NIOServer();
        nioServer.startServer();
    }
}
