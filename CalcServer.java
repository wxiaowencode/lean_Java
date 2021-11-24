package 网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.PreparedStatement;

public class CalcServer {
    private DatagramSocket socket=null;

    public CalcServer(int port) throws SocketException {
        socket=new DatagramSocket(port);
    }
    public void start() throws IOException{
        while(true){
            //1.读取请求并解析
            DatagramPacket requestPacket=new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request =new String(requestPacket.getData(),requestPacket.getLength());
            //2.根据请求计算响应
            String response =process(request);
            //3.把响应写回客户端
            DatagramPacket responsePacket=new DatagramPacket(response.getBytes(),response.getBytes().length,
              requestPacket.getSocketAddress());
            //4.打印日志
            String log=String.format("[%s:%d] req: %s;resp:%s",requestPacket.getAddress().toString(),
            requestPacket.getPort(),request,response );
            System.out.println(log);
        }
    }

     //process内部按照自定义协议进行处理
    private String process(String request) {//
        //1.把request还原成操作数和运算符
        String[] tokens=request.split(";");
        if(tokens.length!=3){
            return "[请求格式出错！]";
        }
        int num1= Integer.parseInt(tokens[0]);
        int num2= Integer.parseInt(tokens[1]);
        int num3= Integer.parseInt(tokens[2]);
        String opertor=tokens[2];
        int result=0;
        if(opertor.equals("+")){
            result=num1+num2;
        }else if(opertor.equals("-")){
            result=num1-num2;
        }else if(opertor.equals("*")){
            result=num1*num2;
        }else if(opertor.equals("/")){
            result=num1/num2;
        }else{
            return "操作格式出错！";
        }
        return result+"";
    }

    public static void main(String[] args) throws IOException {
        CalcServer server=new CalcServer(9090);
        server.start();
    }
}
