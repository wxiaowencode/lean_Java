package 线程;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import org.omg.PortableServer.THREAD_POLICY_ID;

public class ThreadDemo85 {
           private static int countNum=10;
    public static void main(String[] args) {

         Thread t=new Thread(new Runnable() {
             @Override
             public void run() {
                 int temp=0;
                 while(temp<countNum){
                     System.out.println("thread线程正在执中....");
                     try {
                         System.out.println("thread线程即将休眠5秒..");
                         Thread.sleep(5000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         },"Thread-0");

         t.start();
         int tempNum=0;
         while(tempNum<countNum){
             System.out.println("main线程正在执行中....");
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
