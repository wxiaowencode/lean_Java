package 线程;

public class TestDemo4 {
    public static void main(String[] args) {
        Thread t=new Thread(){
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
        };
        t.start();
    }
}
