package 线程;

import java.util.concurrent.Semaphore;

public class ThreadDemo95 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(4);
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                //先尝试申请资源
                try {
                    System.out.println("准备资源成功！");
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //申请到了之后，sleep1000ms
                try {
                    System.out.println("申请资源成功！");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //再释放资源
                semaphore.release();
                System.out.println("释放资源完毕！");
            }
        };

        //创建20个线程
        //让这20个线程来获取资源
        for(int i=0;i<20;i++){
            Thread t=new Thread(runnable);
            t.start();
        }
    }
}
