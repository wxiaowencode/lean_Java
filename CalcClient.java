package 网络编程;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class CalcClient {
    private DatagramSocket socket=null;
    private  String severIp;
    private  int serverPort;

    public CalcClient(String serverIp,int serverPort) throws SocketException {
        this.severIp=serverIp;
        this.serverPort=serverPort;
        this.socket=new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            //1.让用户进行输入
            System.out.println("请输入操作数：num1：");
            int num1=scanner.nextInt();
            System.out.println("请输入操作数：num2: ");
            int num2=scanner.nextInt();
            System.out.println("请输入运算符（+-*/）：");
            String operator=scanner.next();
            //2.构造一个请求
            String request=num1+";"+num2+";"+operator;
            DatagramPacket requestPacket=new DatagramPacket(request.getBytes(),request.getBytes().length,
              InetAddress.getByName(severIp),serverPort );
            socket.send(requestPacket);
            //3.尝试读取服务器的响应
            DatagramPacket responsePacket =new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response=new String(responsePacket.getData(),0,requestPacket.getLength());
            //4.显示结果
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        CalcClient client=new CalcClient("127.0.0.1",9090);
        client.start();
    }
}
