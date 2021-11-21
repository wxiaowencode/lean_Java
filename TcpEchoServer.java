package 网络编程;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class TcpEchoServer {
    //先创建一个socket文件
    private ServerSocket listenSocket =null;

    //创建最开始的构造方法
    public TcpEchoServer(int port) throws IOException {
        listenSocket =new ServerSocket(port);
    }

    //创建启动方法
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while(true){
            //udp的服务器进入主循环，就直接尝试receive读取请求了
            //但是TCP是有连接的.先需要做的是，建立好连接
            //当服务器运行的时候，当服务器是否有客户端来建立连接，不确定~~
            //如果客户端没有建立连接，accept就会阻塞等待。
            //通过accept方法来接受这个连接
            //如果有客户端建立连接了，此时accept就会返回一个Socket对象
            //进一步的服务器和客户端之间的交互，就会交给clientSocket 来完成了
           Socket clientSocket =listenSocket.accept();
           processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        //处理一个连接，在这个连接中可能会涉及客户端和服务器之间的多次交互
        String log=String.format("[%s:%d] 客户端上线！！",
                clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        System.out.println(log);
        try(InputStream inputStream=clientSocket.getInputStream();
            OutputStream outputStream=clientSocket.getOutputStream()){
            while(true){
                //1.读取请求并解析
                //可以直接通过 inputStream 的read 把数据读到一个 byte[],然后再转成一个String
                //但是比较麻烦。还可以借助Scanner来完成这个工作
                Scanner scanner=new Scanner(inputStream);
                if(!scanner.hasNext()){
                    log=String.format("[%s:%d] 客户端下线！！",
                            clientSocket.getInetAddress().toString(),
                            clientSocket.getPort());
                    break;
                }
                String request =scanner.next();
                //2.根据请求计算响应
                String response= process(request);
                //3.把响应写回给客户端
                PrintWriter writer=new PrintWriter(outputStream);
                writer.print(response);
                log=String.format("[%s:%d] req:%s;resp:%s",
                        clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),
                        request,response);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            // 当前的 clientScoket 生命周期，不是跟随整个程序，而是和连接相关。
            //因此就需要每个连接结束，都要进行关闭.
            //否则随着连接的增多，这个socket文件就可能出现资源泄露的情况。
            clientSocket.close();
        }


    }

    //当前是一个回显服务器
    //客户端发啥，服务器就返回啥
    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server =new TcpEchoServer(9090);
        server.start();
    }
}
