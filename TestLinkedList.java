/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-05-11
 * Time: 21:25
 */

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

public class TestLinkedList {
    public Node head;
    public Node last;

    //头插法
    public void addFirst(int data) {

    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        return false;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {

    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
    }
    //得到单链表的长度
    public int size() {
        return -1;
    }
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear() {

    }
}
