package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictSever {
    private DatagramSocket socket=null;

    private HashMap<String,String> dict=new HashMap<>();


    public UdpDictSever(int port) throws SocketException {
        socket=new DatagramSocket(port);

        //对 hash 表的值进行初始化
        dict.put("hello","你好");
        dict.put("dog","狗");
        dict.put("cat","猫");

    }


    private String process(String request){
        //根据请求计算响应
        //todo
        //例如用户的请求是“hello”,就应该返回一个“你好”
        //核心逻辑的实现是“查表”。
        //就是把所有的数据放到数据库中
        //此处简单起见，直接查内存中的hash表。

        return dict.getOrDefault();
    }


    public void start() throws IOException {
        System.out.println("服务器启动！！");
        while(true){
            //1.读取请求并解析
            DatagramPacket requestPacket =new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request=new String(requestPacket.getData(),0,requestPacket.getLength());
            //2.根据请求计算响应
            String response=process(request);
            //3.把响应写回到客户端
            DatagramPacket responsePacket=new DatagramPacket(response.getBytes(),
                      response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            String log=String.format("[%s:%d] req:%s;resp:%s",requestPacket.getAddress().toString());
            System.out.println(log);

        }
    }
}
