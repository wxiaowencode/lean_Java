package 栈;
import java.util.*;
import java.util.Scanner;

class A{

}
class B extends A{

}
class C extends B{

}
class Solution{
    public boolean isValid(String s){
        if( s == null || s.length() == 0){
            return true;
        }
        //定义一个栈，存放左括号
        Stack<Character> stack =new Stack<>();
        //开始遍历当前的字符串s
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //判断当前的字符是哪个左括号，因为题上说，只有3种括号
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                //进入else ，说明当前的i下标是一个右括号
                //先判断当前的栈是否空
                if(stack.empty()){
                    System.out.println("右括号多！");
                    return false;
                }

                char tmp=stack.peek();
                if(tmp == '{' && ch == '}' ||tmp == '[' && ch == ']'||tmp == '(' && ch == ')' ){
                    //出栈当前的左括号，说明匹配成功
                    stack.pop();
                }else{
                    System.out.println("左右括号不匹配！！！");
                    return false;
                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号多！！！");
            return false;
        }

        return true;
    }
}
class Cyinder{
    private double r;
    private double h;

    public double area(double r,double h){
        this.r=r;
        this.h=h;
        double area=3.14*(r*r);
        return area;
    }
    public double volume(double r,double h){
        this.r=r;
        this.h=h;
        double volume=3.14*(r*r)*h;
        return volume;
    }
}
class Point{
    private double x;
    private double y;

    public Point(double x1, double y1) {
    }
    public double distance(Point p1,Point p2){
        double distance=Math.sqrt(Math.abs((p1.x - p2.x)* (p1.x - p2.x)+(p1.y - p2.y)* (p1.y - p2.y)));
        return distance;
    }
}


public class TestDemo {
    public static void main(String[] args) {

    }
    public static void main12(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        System.out.println(p1.distance(p1, p2));
    }
    public static void main11(String[] args) {
        Cyinder cyinder=new Cyinder();
        Scanner scanner=new Scanner(System.in);
        double r=scanner.nextDouble();
        double h=scanner.nextDouble();
        System.out.println(cyinder.area(r,h));
        System.out.println(cyinder.volume(r,h));
    }
    public static void main9(String[] args) {
        Scanner scanner= new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.next();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(!sb.toString().contains(ch+"")){
                    sb.append(ch);
                }
            }
            System.out.println(sb);
        }
    }
    public static void main8(String[] args) {
       Object o = new Object(){

            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("gaobo"));

    }
    public static void main7(String[] args) {
         A a=new B();
         A a1= new C();
         B b=new C();
    }
    public static void main6(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());//1
        System.out.println(myQueue.poll());// 1
        System.out.println(myQueue.poll());//2
    }
    public static void main3(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();

        Deque<Integer> queue2 =new LinkedList<>();
        Deque<Integer> queue =new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());//得到队头元素
        System.out.println(queue.poll());//出队 1
        System.out.println(queue.poll());//出队 2
    }
    public static void main2(String[] args) {
        MyStack<String> myStack2=new MyStack();
        myStack2.push("hello");
        myStack2.push("gaobo");
        myStack2.push("cool");
        System.out.println(myStack2.peek());//cool
        System.out.println(myStack2.pop());//cool
        System.out.println(myStack2.pop());//gaobo
        System.out.println(myStack2.pop());//hello
        System.out.println(myStack2.empty());//是否为空
    }
    public static void main1(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//1
        System.out.println(myStack.empty());//true
    }
}
