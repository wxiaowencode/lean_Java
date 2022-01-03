import com.sun.xml.internal.ws.api.server.SDDocument;

import java.awt.*;
import java.time.Instant;

class Dog{
    private String name;
    private int age;

    public Dog(){
        this("张三",10);
    }
    public Dog(String name,int age){
        this.name=name;
        this.age=age;
    }
//    public void run(){
//        Dog d=new Dog("张三", 10);
//
//        System.out.println(d.age);
//        System.out.println("这里正在执行run方法！");
//    }
    public void jump(){

        System.out.println("这是jump方法！");
    }
    public void print(){
        System.out.println(this.name);
        System.out.println(this.age);
    }

}
class DogChild extends Dog{

    @Override
    public void jump(){
        super.print();
        System.out.println("这是小狗的jump方法！");
    }
}

class Person{
    void eat(){
        System.out.println("吃！");
    }
    void work(){
        System.out.println("工作！");
    }
}
class Student extends Person {
    @Override
    public void eat(){
        System.out.println("吃垃圾食品！");
    }
    @Override
    public void work(){
        System.out.println("听课！");
    }
}
class Teacher extends Person{
    @Override
    public void eat(){
        System.out.println("吃健康食品！");
    }
    @Override
    public void work(){
        System.out.println("讲课！");
    }
}
public class TestDemo {


    public static void main(String[] args) {
        Person p=new Person();
        p.eat();
        p.work();
        System.out.println("==============");
       Person p1=new Student();
        p1.eat();
        p1.work();
       Student student=(Student) p1;
        p1.eat();
        p1.work();
         System.out.println("================");
        Person p2=new Teacher();
        p2.eat();
        p2.work();
        Teacher teacher=(Teacher) p2;
        p2.eat();
        p2.work();
    }

    public static void main1(String[] args) {

//        DogChild dogChild=new DogChild();
//        dogChild.jump();

//       Animal animal=new Animal();
//        System.out.println(animal.a);
//        System.out.println(animal.b);
//        System.out.println(animal.i);
        //new TestDemo();
//        Dog dog=new Dog("张三", 10);
//         dog.run();
//            int a=0x64;
//            int b=0144;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println("-================");
//        //将double转换为int
//        double d=3.1441;
//        Double D=new Double(d);
//        int i=D.intValue();
////        System.out.println(i);
//        int i=0;
//        double a=0;
//        String s="123";
//       // i=Integer.parseInt(s);
//        int c=0;
//
//        c=Integer.valueOf(s);
//        System.out.println(c);
//        a=c;
//       /// System.out.println(s);
//        System.out.println(a);
//        System.out.print("asf\n");
//        boolean a=true;
//        boolean b=false;
//        boolean c=a&b;
//        boolean d=a&&b;
//        int a1=5;
//        int b1=4;
//        int c1=a1&b1;
//        System.out.println(c);
//        System.out.println(d);
        //    //静态方法块
//    static{
//        System.out.println("这是静态方法块！");
//    }
//
//
//
//    public TestDemo(){
//        System.out.println("这是构造函数！");
//    }
//
//    //普通方法块
//    {
//        System.out.println("这是普通方法块！");
//    }



////        System.out.println(c1);
//        long a=0;
//        switch (a){
//
//        }
    }
}
