package org.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yishan
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
       ServerSocket serverSocket = new ServerSocket(9000);
       while (true){
           System.out.println("等待连接");
           //阻塞连接
           Socket socket = serverSocket.accept();
           System.out.println("有客户端连接了");
           //可以开线程来支持多处理，但不支持高并发
           handler(socket);
       }

    }

    public static void handler(Socket socket) throws IOException {
             byte[] bytes=new byte[1024];
             //没有数据阻塞
             int read=socket.getInputStream().read(bytes);
             if(read!=-1){
                 System.out.println("客户端接受的数据："+new String(bytes,0,read));
             }
    }
}
