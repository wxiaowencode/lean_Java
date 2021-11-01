package 线程;

public class ThreadDemo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){

                }
            }
        };
        System.out.println(t.getId()+":"+t.getState());
        t.start();
        System.out.println(t.getId()+":"+t.getState());
        Thread.sleep(3000);
        Thread.sleep(1000);
        System.out.println(t.getId()+":"+t.getState());

    }
}
