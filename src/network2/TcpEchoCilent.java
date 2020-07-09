package network2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-07-07
 * Time:15:07
 * 一万年太久，只争朝夕，加油
 */
/*
  客户端：
     1、创建一个客户端对象Socket,构造方法中绑定服务器的ip地址和端口号
     2、使用方法获取网络字节输出流对象
     3、使用网络字节输出流对象write()给服务器发送数据
         主循环里面：先读取用户输入的内容，构建一个请求数据
                    将这个请求发送给服务器
                    从服务器中读取响应
                    把这个响应返回给用户（展示到界面上）
     4、使用getInputStream()获取网络字节输入流对象
     5、使用read()方法读取服务器回写的数据
     6、流使用完之后释放资源（关socket)
 */
public class TcpEchoCilent {
    Socket socket=null;

    public TcpEchoCilent(String ip,int port) throws IOException {
        socket = new Socket(ip,port);
    }
    //接下来写一个方法来完成客户端和服务器的交互
    public void start() throws IOException {
        System.out.println("客户端启动");
        //用户输入数据
        Scanner sc = new Scanner(System.in);
        //获取到网络字节流对象，把他们写到try语句里面，说明不用close关闭了
        try (BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                //读入用户输入的内容
                String request = sc.nextLine();
                //输入完毕
                if (request.equals("exit")) {
                    break;
                }
                //把这个内容构造成请求发送给服务器
                //按行发送
                os.write(request + "\n");
                //把缓冲区的内容写到服务器上
                os.flush();
                //接收服务器的响应
                //按行读取
                String response = is.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        //先创建对象，再调用方法
        TcpEchoCilent t=new TcpEchoCilent("127.0.0.1",9090);
        t.start();

    }
}
