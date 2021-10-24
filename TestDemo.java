import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-06-04
 * Time: 12:33
 */

public class TestDemo {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);

        System.out.println(myQueue.peek());//1
        System.out.println(myQueue.poll());//1
        System.out.println(myQueue.poll());//2
        System.out.println(myQueue.poll());//3

        System.out.println(myQueue.isEmpty());//true

        System.out.println(myQueue.poll());//

    }

    public static void main4(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();



        Deque<Integer> queue2 = new LinkedList<>();



        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.peek());//1 得到队头元素
        System.out.println(queue.poll());//1 出队
        System.out.println(queue.poll());//2 出队

        //LinkedList<Integer> linkedList = new LinkedList<>();

    }

    public static void main3(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//2
        System.out.println(myStack.pop());//1
        System.out.println(myStack.empty());//true
        System.out.println("============================");
        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("hello");
        myStack2.push("gaobo");
        myStack2.push("cool");
        System.out.println(myStack2.peek());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.empty());



    }
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());//3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//2
        System.out.println(myStack.pop());//1
        System.out.println(myStack.empty());//true
    }
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);//入栈
        // 1 2 3
        int ret = stack.pop();//删除栈顶的元素  出栈
        System.out.println(ret);

        int ret2 = stack.peek();//得到栈顶元素但是不删除
        System.out.println(ret2);
        stack.pop();//2
        stack.pop();//1

        boolean flg = stack.empty();
        System.out.println(flg);
    }
}
