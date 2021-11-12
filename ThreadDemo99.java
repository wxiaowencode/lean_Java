package 线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadDemo99 {
    static class ThreadPool{
        static class Worker extends Thread{
            private BlockingQueue<Runnable> queue=null;



            public  Worker(BlockingQueue<Runnable> queue){
                this.queue=queue;
            }
            @Override
            public void run() {
                //在这里实现工作线程的具体逻辑
                //需要从阻塞队列中取出任务
                while(true){
                    try {
                        Runnable command=queue.take();
                        //通过command 来执行这个任务。
                        command.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //包含一个阻塞队列，用来组织任务
        private BlockingDeque<Runnable> queue =new LinkedBlockingDeque<>();

        //用list来存放当前的工作线程。
        private List<Thread> workers=new ArrayList<>();

        private static final int MAX_WORKER_COUNT=10;

        //提供一个方法，把需要执行的任务加入到线程池中
        //submit不光可以把任务放到阻塞队列中，同时也可以负责创建线程。
        public void submit(Runnable command) throws InterruptedException {
           if(workers.size()<MAX_WORKER_COUNT){
               //如果当前工作线程的数量不足线程数目上限，就创建出新的线程。
               //工作线程专门通过一个新的类来完成
               Worker worker=new Worker(queue);
               worker.start();
               workers.add(worker);
           }
            queue.put(command);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool=new ThreadPool();
        for(int i=0;i<10;i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hellllllo");
                }
            });
        }
    }
}
