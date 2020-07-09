package network2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-07-07
 * Time:14:11
 * 一万年太久，只争朝夕，加油
 */
/*
    向服务器发送连接请求
    向服务器发送数据
    读取服务器回写数据
    套接字：包含了ip地址和端口号的网络单位
    构造方法：
    Socket(String host,int port)
          host:服务器名称/ip
          port:服务器端口号
    成员方法：
          getOutputStream()  输出流
          getInputStream()   输入流

     步骤：
     1、创建一个客户端对象Socket,构造方法中绑定服务器的ip地址和端口号
     2、使用方法获取网络字节输出流对象
     3、使用网络字节输出流对象write()给服务器发送数据
     4、使用getInputStream()获取网络字节输入流对象
     5、使用read()方法读取服务器回写的数据
     6、流使用完之后释放资源（关socket)

     注意事项：
     1、客户端和服务器端进行交互必须使用Socket中提供的网络流，不能使用自己创建的流对象
     2、当我们创建对象Socket的时候，客户端就会请求服务器和服务器进行三次握手，建立连接
         如果服务器没有启动，就会抛出异常
         服务器启动的话，就可以进行交互了
 */
public class TcpCilent {
    public static void main(String[] args) throws IOException {

        //1、创建一个客户端对象Socket,构造方法中绑定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1", 9090);
        //2、使用方法获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();
        //3、使用网络字节输出流对象write()给服务器发送数据
        os.write("你好，服务器".getBytes());
        // 4、使用getInputStream()获取网络字节输入流对象
        InputStream is=socket.getInputStream();
        // 5、使用read()方法读取服务器回写的数据
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6、流使用完之后释放资源（关socket)
        socket.close();

    }
}
