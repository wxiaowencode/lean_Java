package 线程;

public class ThreadDemo84 {
    private static int countNum=6;
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                int tempNum=0;
                while(true){
                    Thread.yield();
                    System.out.print("张三"+" ");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tempNum++;
                }
            }
        },"THREAD-1");
        t.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                int tempD=0;
                while(tempD<countNum){
                    System.out.print("李四"+" ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tempD++;
                }
            }
        },"THREAD-2");
        t2.start();
    }
}
