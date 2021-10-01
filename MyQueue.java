package 栈;

class Node{//表
    private int val;
    private Node next;
    public int getVal(){
        return val;
    }
    public void setVal(){
        this.val=val;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node node){
        this.next=next;
    }
    public Node(int val){
        this.val=val;
    }
}
public class MyQueue {
    private Node first;
    private Node last;
    public boolean isEmpty(){
        return this.first == null;
    }
    //入队
    public void offer(int val){
        //尾插法 判断是否是不是第一次插入
        Node node =new Node(val);
        if(this.first == null){
            this.first = node;
            this.last = node;
        }else{
            this.last.setNext(node);
            this.last =node;
        }
    }

    //出队
    public int poll(){
        if(isEmpty()){
            throw  new UnsupportedOperationException("队列空！！！");
        }
        int ret=this.first.getVal();
        this.first=this.first.getNext();
        return ret;
    }
    //得到队头元素不删除
    public int peek(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列空！！");
        }
        return this.first.getVal();
    }
    //队列是否空

}
