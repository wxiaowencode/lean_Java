package 线程;

public class ThreadDemo21 {
    //饿汉模式
    static class Singleton{
        //把构造方法设为private，防止类外面调用构造方法，也就禁止了调用者在其他地方创建实例的机会。
        private Singleton(){

        }
        private static Singleton instance=new Singleton();
        public static Singleton getInstance(){
            return instance;
        }
    }
}
