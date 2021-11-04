package 线程;

public class TestDemo15 {

       static class Counter{
            public int count=0;

            synchronized   public void increase(){
                count++;
            }
        }
        static Counter counter =new Counter();

       public static void main(String[] args){
           Thread t1=new Thread(){
               @Override
               public void run() {
                   for(int i=0;i<100000;i++){
                       counter.increase();
                   }
               }
           };
          // t1.start();
           Thread t2=new Thread(){
               @Override
               public void run() {
//                   for(int i=0;i<50000;i++){
//                       counter.increase();
//                   }
               }
           };
           t1.start();
           t2.start();
           try {
               t1.join();
               t2.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(counter.count);
       }

}
