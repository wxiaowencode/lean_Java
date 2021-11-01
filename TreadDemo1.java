package 线程;

class Mythread extends Thread{
    @Override//run是线程中的任务
    public void run(){
        System.out.println("hello my thread!");
    }
}
public class TreadDemo1 {
    public static void main(String[] args) {
        Thread t=new Mythread();
        // start 方法，会在操作系统中真的创建一个线程出来，(内核中搞个pcb，加入到双向链表当中)
        t.start();
    }
}
