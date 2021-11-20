package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket=null;
    //port 表示端口号
    //服务器在启动的时候，需要关联（绑定）上一个端口号.
    //受到数据的时候，就会根据这个端口号来决定把数据交给哪个进程
    //虽然此处port写的类型是int 但是实际上端口号是一个两个字节的无符号整数
    //范围0-65535
    public UdpEchoServer (int port) throws SocketException {
        socket=new DatagramSocket(port);
    }

    //通过这个方法来启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动！！");

        //服务器一般都是持续运行的（7*24）

        while(true){
            //1.读取请求 当前服务器不知道客户端啥时候发来请求 receive方法也会阻塞。
            //如果真的有请求过来了，此时 receive就会返回。
            //参数DatagramPacket 是一个输出型参数，socket中读到的数据会设置到这个参数的对象中.
            DatagramPacket requestPacket =new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);//如果没有请求，就会陷入阻塞
            //把requestPacket 对象里面的内容取出来，作为一个字符串.
            String request =new String(requestPacket.getData(),0,requestPacket.getLength());
            //2.根据请求来计算响应.
            String response =process(request);
            //3.把响应写回到客户端，这时候也需要构造一个DatagramPacket
            //此处给DatagramPacket 中设置的长度，必须是：“字节的个数”。
            //如果直接取response.length（）此处得到的是，字符串的长度，也就是字符的个数。
            //当前的responsePacket在构造的时候，还需要指定这个包要发给谁
            //其实发送给的目标，就是发请求的哪一方。
            DatagramPacket responsePacket=new DatagramPacket(response.getBytes(),response.getBytes().length,
                     requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4.加上日志打印
            // %d 表示要打印一个有符号十进制的整数.%s表示要打印一个字符串
            //可以使用字符串+拼接，完全可以，只不过写起来会比较麻烦
            String log=String.format("[%s:%d] req:%s;resp:%s",requestPacket.toString(),
                    requestPacket.getAddress().toString(),
                    requestPacket.getPort(),
                    request,response);
            System.out.println(log);
        }
    }

    //此处的process 方法负责的功能，就是根据请求来计算响应。
    //由于当前是一个 回显服务器，就把客户端发的请求直接返回去即可。

    private String process(String request) { return request; }

    public static void main(String[] args) throws IOException {

        UdpEchoServer server=new UdpEchoServer(9090);
        //启动服务器
        server.start();
    }
}
