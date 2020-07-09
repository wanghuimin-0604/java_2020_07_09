package network2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-07-07
 * Time:14:28
 * 一万年太久，只争朝夕，加油
 */
/*
  服务器端：
        ServerSocket类来实现服务器端
        服务器端必须知道哪个客户端请求自己的，因此使用成员方法Socket accept()来获取到客户端的Socket对象
        接收客户端请求、给客户端返回数据
    步骤：
    1、创建服务器ServerSocket对象并向系统要一个指定的端口号
    2、使用accept(）方法获取到请求的客户端对象
    3、使用输入流对象getInputStream获取到InputStream
    4、使用read()方法读入客户端的请求
    5、使用输出流对象getOutputStream获取到OutputStream
    6、使用write()将响应写回给客户端
    7、关闭ServerSocket
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器ServerSocket对象并向系统要一个指定的端口号
        ServerSocket serverSocket = new ServerSocket(9090);
        //2、使用accept(）方法获取到请求的客户端对象
        Socket cilentSocket=serverSocket.accept();
        //3、使用输入流对象getInputStream获取到InputStream
        InputStream inputStream=cilentSocket.getInputStream();
        //4、使用read()方法读入客户端的请求
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //5、使用输出流对象getOutputStream获取到OutputStream
        OutputStream outputStream=cilentSocket.getOutputStream();
        //6、使用write()将响应写回给客户端
        outputStream.write("收到，谢谢".getBytes());
        //7、关闭ServerSocket
        cilentSocket.close();
        serverSocket.close();


    }
}
