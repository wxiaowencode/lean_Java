package 线程;

public class ThreadDemo88 {
    private static boolean flg=true;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
               while(flg){
                   System.out.println("线程运行中...");
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                System.out.println("线程结束！！");
            }
        };
        t.start();

        //主循环中也等待3秒
        Thread.sleep(6000);

        //3秒中之后，就把flag改成false;
        flg=false;
    }
}
