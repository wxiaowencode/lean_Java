package 线程;

public class ThreadDemo20 {
    static class WaitTask implements Runnable{
        private  Object locker =null;

        public WaitTask(Object locker) {
            this.locker = locker;
        }

        @Override
        public void run() {
            //进行wait的线程
          synchronized(locker){
              System.out.println("wait 开始");

              try {
                  //直接调用wait，相当于this。wait（），
                  // 也就是针对waittask 对象来进行等待。
                  locker.wait();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("wait 结束");
          }
        }
    }
    static class NotifyTask implements  Runnable{
        private Object locker=null;

        public NotifyTask(Object locker) {
            this.locker = locker;
        }

        @Override
        public void run() {
            //进行notify的线程
            synchronized(locker){
                System.out.println("notify 开始");
                locker.notify();
                System.out.println("notify 结束");
                    //直接调用wait，相当于this。wait（），
                    // 也就是针对waittask 对象来进行等待。
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       //为了解决刚才的问题，专门创建一个对象，去负责进行加锁、通知操作
        Object locker= new Object();
        Thread t1=new Thread(new WaitTask(locker));
        Thread t2=new Thread(new NotifyTask(locker));
        t1.start();
        Thread.sleep(3000);
        t2.start();
    }
}
