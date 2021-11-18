package 线程;

public class ThreadTemo86 {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                int i=0;
                System.out.println("thread线程开始执行！");
                while(i<5){
                    System.out.println("thread线程执行中");
                    try {
                        Thread.sleep(1000);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread线程执行结束！！！");
            }
        };
        t.start();
        for(int i=0;i<3;i++){
            System.out.println("main线程执行中！！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("main线程被阻塞...");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程被唤醒..");
        int b=0;
        while(b<5){
            System.out.println("main线程正在执行...");
            b++;
        }
        System.out.println("main线程执行结束！");

    }
}
