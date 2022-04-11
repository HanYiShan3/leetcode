package org.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author yishan
 */
public class NioServer {
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(9000));
        socketChannel.configureBlocking(false);
        //多路复用器引入
        Selector selector = Selector.open();
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功");
        while (true) {
            //阻塞等待需要处理的事情发生
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server= (ServerSocketChannel) key.channel();
                    SocketChannel socketChannels = server.accept();
                    socketChannels.configureBlocking(false);
                    SelectionKey sk = socketChannels.register(selector, SelectionKey.OP_READ);
                    System.out.println("连接成功");
                }else if(key.isReadable()){
                    SocketChannel socketChannel1= (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len=socketChannel1.read(byteBuffer);
                if(len>0){
                    System.out.println("接受到的消息："+new String(byteBuffer.array()));
                }else if(len==-1){

                    System.out.println("客户端断开连接");
                    socketChannel.close();
                }

                }
                iterator.remove();
            }
//            SocketChannel socketChannel1=socketChannel.accept();
//            if(socketChannel1!=null){
//                System.out.println("连接成功");
//                socketChannel1.configureBlocking(false);
//                channelList.add(socketChannel1);
//            }
//            Iterator<SocketChannel> iterator=channelList.iterator();
//            while (iterator.hasNext()){
//                SocketChannel sc=iterator.next();
//                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
//                int len=sc.read(byteBuffer);
//                if(len>0){
//                    System.out.println("接受到的消息："+new String(byteBuffer.array()));
//                }else if(len==-1){
//                    iterator.remove();
//                    System.out.println("客户端断开连接");
//                }
//            }

        }
    }
}
