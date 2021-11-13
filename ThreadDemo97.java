package 线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo97 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for(int i=1;i<=1000;i++){
                    sum+=i;
                }
                return sum;
            }
        };
        //由于thread 不能直接传一个callable实例，就需要一个辅助的类来包装一下
        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        Thread t=new Thread(futureTask);
        t.start();

        //尝试在主线程获取结果
        //如果FutureTask中的结果还没生成，此时就会阻塞等待。
        //一直等到啥时候，等到最终的线程把这个结果算出来之后，get才会返回
        Integer result=futureTask.get();
        System.out.println(result);
    }
}
