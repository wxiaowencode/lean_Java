package 线程;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//生产者与消费者模型
public class ThreadDemo22 {
        static class BlockintQueue{
            //1000 就相当于队列的最大容量，此时暂时不考虑扩容的问题。
            private int[] items=new int[1000];
            private int head=0;
            private int tail=0;
            private int size=0;

            //用put来入队列
            public void put(int item){
                //入队列,就把新的元素放到tail位置上
                if(size==items.length){
                    //队列已经满了，对于阻塞队列来说就要阻塞队列
                    //TODO
                    return;
                }
                items[tail]=item;
                tail++;
                //如果到达末尾，就回到起始位置
                if(tail>=items.length){
                    tail=0;//tail%=items.length
                }
                size++;
            }
            //用take来出队列
            public int take(){
                if(size==0){
                    //阻塞队列如果队列为空。再尝试取元素，就要阻塞。
                    //TODO
                    return 0;
                }
                int ret=items[head];
                head++;
                if(head>=items.length){
                    head=0;
                }
                size--;
                return ret;
            }
        }

    public static void main2(String[] args) {
        //使用一个BlocKingQueue作为交易场所
        BlockingQueue<Integer> queue=new LinkedBlockingQueue<>();


        //搞一个线程作为消费者
        Thread customer =new Thread(){
            @Override
            public void run() {
                try {
                    //取出队首元素
                    Integer value=queue.take();
                    System.out.println("消费元素"+value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        //搞一个线程作为生产者
        Thread producer =new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    System.out.println("生产了元素："+i);
                    try {
                        queue.put(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
    }
    public static void main1(String[] args) throws InterruptedException {
        //LinkedBlockingQueue 内部是基于链表来实现的
        BlockingQueue<String> queue=new LinkedBlockingQueue<>();
     //put带有阻塞功能，但是offer不带有，使用阻塞队列一般都是使用put
     //queue.offer("hello");
     queue.put("hello");
     String elem=queue.take();//取出队首元素
        System.out.println(elem);
        elem=queue.take();
        System.out.println(elem);
    }
}
