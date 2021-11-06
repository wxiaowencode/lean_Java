package 线程;

public class ThreadDemo23 {
    //懒汉模式

    static class Singleton{
        private Singleton(){}

        private  static  volatile Singleton instance=null;
        public static Singleton getInstance() {
            if(instance==null){
                synchronized(Singleton.class){
                    if (instance == null){
                        instance =new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        //通过这个方法来获取实例，就能保证只有唯一实例。
        Singleton instance=Singleton.getInstance();
    }
}
