package 线程;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo96 {
    static class Counter{
        public int count=0;
        public ReentrantLock locker=new ReentrantLock();
        public void increase(){
            locker.lock();
            count++;
            locker.unlock();
        }
    }
    public static void main(String[] args) {
        Counter counter=new Counter();

           Thread t1=new Thread(){
               @Override
               public void run() {
                   for(int i=0;i<50000;i++){
                       counter.increase();
                   }
               }
           };
        Thread t2=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<50000;i++){
                    counter.increase();
                }
            }
        };
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.count);
    }
}
