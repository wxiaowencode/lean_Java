package 栈;
import java.util.*;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
public class MyStack<T> {

    private T[] elem;//数组
    private int top;//栈顶指针,当前可以存放数据的下标

    public MyStack(){
        this.elem=(T[])new Object[10];
    }
    //入栈操作
    public void push(T item){
        //1.判断当前栈是否是满的
        if(isFull()){
            this.elem=Arrays.copyOf(this.elem,2*this.elem.length);
            //扩容
        }
        //2.elem[top] = item  top++;
        this.elem[this.top++]=item;
    }
    public boolean isFull(){
        return this.elem.length == this.top;
    }
    //出栈操作
    public T pop(){
        //1.判断栈是否为空
        if(empty()){
            throw new UnsupportedOperationException("栈为空！！");
        }
        //2.抛出栈顶元素
        T ret=this.elem[this.top-1];
        this.top--;
        return ret;
    }
    public boolean empty(){
        return this.top == 0;
    }
    //得到栈顶元素，但是不删除
    public T peek(){
        if(empty()){
            throw new UnsupportedOperationException("栈为空！! ");
        }
        return this.elem[this.top-1];
    }
}
