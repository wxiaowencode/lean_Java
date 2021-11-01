package 线程;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());//把Runnable实例作为Thread的参数
        t.start();
    }
}
