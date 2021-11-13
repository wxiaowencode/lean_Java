package 线程;

public class ThreadDemo98 {

    static class Result{
        public int sum=0;
        public Object locker=new Object();
    }
    public static void main(String[] args) throws InterruptedException {
        Result result=new Result();
        Thread t=new Thread(){
            @Override
            public void run() {
                int sum=0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                result.sum=sum;
                synchronized(result.locker){
                    result.locker.notify();
                }
            }
        };
        t.start();
        //此处我们期望，这个线程的计算结果能够被主线程获取到
        //为了解决这个问题，就需要引入一个辅助的类。
        //当代码写成这个样子的时候，发现主线程中是无法得到sum的值的
        //主要是因为当前t线程和主线程之间是并发的关系。
        //执行的先后顺序不能确定
        //解决方案是，让main这个线程先等待（wait）.t线程计算完毕之后，通知唤醒main线程即可
       synchronized(result.locker){
           while(result.sum==0){
               result.locker.wait();
           }
       }
        System.out.println(result.sum);
    }
}
