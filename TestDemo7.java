package 线程;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class TestDemo7 {
    private static final long count =10_0000_0000l;

    public static void serial(){
        //System.currentTimeMillis() 用来获取当前毫秒级时间戳
        long beg=System.currentTimeMillis();
        int a=0;
        for(long i=0;i<count;i++){
            a++;
        }
        int b=0;
        for(long i=0;i<count;i++){
            b++;
        }
        long end=System.currentTimeMillis();
        System.out.println("time:"+(end-beg));
    }
    public static void concurrency(){
        long beg=System.currentTimeMillis();
        Thread t1=new Thread(){
            @Override
            public void run() {

           int a=0;
                for(long i=0;i<count;i++){
                    a++;
                }
            }
        };
        t1.start();

        Thread t2=new Thread(){
            @Override
            public void run() {
                int b=0;
                for(long i=0;i<count;i++){
                    b++;
                }
            }
        };
        t2.start();
        //需要保证t1和t2都执行完了之后
        //再结束计时

        try {
            //join就是等待对应的线程结束。
            //当t1和t2没执行完之前，join方法就会阻塞等待。
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        System.out.println("time:"+(end-beg));
    }
    
    public static void main(String[] args) {
        //serial();
        concurrency();
    }
}
