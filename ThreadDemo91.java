package 线程;

public class ThreadDemo91 {
      private static final long count=10_0000_0000;
      public static void main(String[] args) throws InterruptedException{

          //调用并发
          concurrency();

          //调用串行
          serial();
      }
      private static void concurrency() throws InterruptedException{
          long begin =System.nanoTime();
          //利用一个线程计算a的值
          Thread thread =new Thread(new Runnable() {
              @Override
              public void run() {

                      int a=0;
                      for(long i=0;i<count;i++){
                          a--;
                      }
              }
          });
          thread.start();
          //主线程内计算b的值
          int b=0;
          for(long i=0;i<count;i++){
              b--;
          }
          //等待线程thread运行结束
          thread.join();
          //统计耗时
          long end=System.nanoTime();
          double ms=(end-begin)*1.0/1000/1000;
          System.out.printf("并发：%f 毫秒%n",ms);
      }
      private static void serial(){
          //全部在主线程内计算a、b的值
          long begin=System.nanoTime();
          int a=0;
          for(long i=0;i<count;i++){
              a--;
          }
          int b=0;
          for(long i=0;i<count;i++){
              b--;
          }
          long end=System.nanoTime();
          double ms=(end-begin)*1.0/1000/1000;
          System.out.printf("串行：%f 毫秒%n",ms);
      }
}
