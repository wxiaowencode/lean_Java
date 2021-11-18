package 线程;

public class ThreadDemo83 {
    public static void main(String[] args) {
        for(Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}
