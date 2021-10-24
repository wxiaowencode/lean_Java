/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-06-04
 * Time: 20:58
 */
class Node {
    private int val;
    private Node next;
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {
    private Node first;
    private Node last;
    //入队
    public void offer(int val) {
        //尾插法  需要判断是不是第一次插入
        Node node = new Node(val);
        if(this.first == null) {
            this.first = node;
            this.last = node;
        }else {
            this.last.setNext(node);//last.next = node;
            this.last = node;
        }
    }
    //出队
    public int poll() {
        //1判断是否为空的
        if(isEmpty()) {
            throw new UnsupportedOperationException("队列为空！");
        }
        //this.first = this.first.next;
        int ret = this.first.getVal();
        this.first = this.first.getNext();
        return ret;
    }
    //得到队头元素但是不删除
    public int peek() {
        //不要移动first
        if(isEmpty()) {
            throw new UnsupportedOperationException("队列为空！");
        }
        return this.first.getVal();
    }
    //队列是否为空
    public boolean isEmpty() {
        return this.first == null;
    }
}
