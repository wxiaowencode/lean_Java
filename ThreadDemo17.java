package 线程;
import java.util.*;
public class ThreadDemo17 {
    static class Counter{
        //加上volatile之后，此时后续的针对flag的读写操作，就都能保证一定是操作内存
        // volatile 只能保证内存可见性，不能保证原子性
       volatile public int flag=0;
    }

    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread t1=new Thread(){
            @Override
            public void run() {
                while(counter.flag==0){
                    // 假设要执行一些操作
                }
                System.out.println("循环结束");
            }
        };
        t1.start();

        Thread t2=new Thread(){
            @Override
            public void run() {
                //让用户输入一个整数，用这个用户输入的值来替换 counter.flag的值
                Scanner scanner=new Scanner(System.in);
                System.out.println("请输入一个整数：");
                counter.flag=scanner.nextInt();
            }
        };
        t2.start();
    }
}
