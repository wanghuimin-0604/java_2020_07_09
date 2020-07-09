package network2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-07-07
 * Time:15:24
 * 一万年太久，只争朝夕，加油
 */
/*
  服务器端：
    1、创建服务器ServerSocket对象并向系统要一个指定的端口号
      主循环：
        2、使用accept(）方法获取到请求的客户端对象
        处理这个连接
        3、使用输入流对象getInputStream获取到InputStream
        4、使用read()方法读入客户端的请求
        5、使用输出流对象getOutputStream获取到OutputStream
        6、使用write()将响应写回给客户端
        7、关闭ServerSocket

 */
public class TcpEchoServer {
    ServerSocket socket=null;

    public TcpEchoServer(int port) throws IOException {
        socket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
            //从客户端获取一个连接请求
            Socket cilentSocket=socket.accept();
            process(cilentSocket);
        }

}

    private void process(Socket cilentSocket)  {
        //屏幕上输出服务器的ip地址和端口号
        System.out.printf("[%s:%d] 客户端上线\n", cilentSocket.getInetAddress().toString(),
                cilentSocket.getPort());
        try(BufferedReader br=new BufferedReader(new InputStreamReader(cilentSocket.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(cilentSocket.getOutputStream()))){
            while(true) {
                //读取到客户端的请求
                String request = br.readLine();
                //处理客户端请求并做出响应
                String response=deal(request);
                //将响应写回给客户端
                bw.write(response+"\n");
                bw.flush();
                //输出客户端发送的请求
                //System.out.println(request);
                //输出服务器的ip地址、端口号、以及请求和响应的内容
                System.out.printf("[%s:%d] req:%s;resp:%s\n", cilentSocket.getInetAddress().toString(),
                        cilentSocket.getPort(), request, response);
            }

        }catch(IOException e){
            e.printStackTrace();
            System.out.printf("[%s:%d] 客户端下线\n", cilentSocket.getInetAddress().toString(),
                    cilentSocket.getPort());
        }
    }
   //客户端发送什么，服务器就返回什么
    private String deal(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer t=new TcpEchoServer(9090);
        t.start();

    }
}
