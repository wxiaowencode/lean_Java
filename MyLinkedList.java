package 重新学习线性表;

import java.util.List;

//用一个类来抽象出最基础的节点。
class ListNode{
    public int val;//每个节点的数值域
    public ListNode next;//这个next只是一个引用，储存了下一个节点的地址，所以为节点类型。
    public ListNode(){

    }
    public ListNode(int val){
        this.val=val;
    }
}

public class MyLinkedList {
    public ListNode head;

    //头插
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public ListNode findSubOne(int index) {
        ListNode cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //任意位置插入
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("pos位置不合法！！");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }

        ListNode cur = findSubOne(index);
        ListNode node = new ListNode(index);
        node.next = cur.next;
        cur.next = node;
        
    }

    //查找是否包含关键字key
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while (prev.next != null) {
            if (prev.val == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为Key的节点
    public void remove(int key) {
        if (this.head.val == key) {
            this.head = this.head.next;
        }
        ListNode prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有你要删除的节点！");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;

    }


    //删除所有值为key的节点
    public void removeAll(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                cur.next = prev.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            if (this.head.val == key) {
                this.head = this.head.next;
            }
        }
    }

    //得到链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }


    public void clear() {
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
    }

    //    public void creatList(){
//        ListNode listNode1=new ListNode(12);
//        ListNode listNode2=new ListNode(45);
//        ListNode listNode3=new ListNode(6);//每次new一个，新创建一个对象的时候，能确定的只有val值。
//        ListNode listNode4=new ListNode(8);
//        ListNode listNode5=new ListNode(5);
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
//        this.head=listNode1;
//    }
    public boolean chkPalindrome() {
        //1.找到中间节点
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null && fast.next!=null) {//!!!!
            fast = fast.next.next;
            slow = slow.next;
        }//此循环结束时。slow位置就是中间节点的位置
        //2.反转
        ListNode cur=slow.next;
        ListNode curNext=cur;
        //curNext=cur.next;
        while(cur!=null){
            cur.next=slow;
            slow=curNext;
            cur=curNext.next;
            curNext=cur.next;
        }
        //3.一个从前往后，一个从后往前  如果相遇，则证明回文
        while(head!=slow){
            if(head.val==slow.val){
                if(head.next==slow){//偶数情况下
                    return true;
                }
                head=head.next;
                slow=slow.next;
            }else{
                return false;
            }
        }
        return true;
    }



    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                break;
            }
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next.next;
        }
        return fast;

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //0.定义一个pl和ps分别指向最长和最短的链表
        ListNode pl=headA;
        ListNode ps=headB;
        //1.分别求得两个链表的长度
        int lenA=0;
        int lenB=0;
        while(pl !=null){
            lenA++;
            pl=pl.next;
        }
        while(ps !=null){
            lenB++;
            ps=ps.next;
        }
        pl=headA;
        ps=headB;
        int len=lenA-lenB;
        if(len<0){
            pl=headB;
            ps=headA;
            len=-len;
        }

        //2.让pl先走差值步
        while(len!=0){
            pl=pl.next;
            len--;
        }
        //3.pl和ps一起走，相遇或null返回
        while(pl!=ps){
            pl=pl.next;
            ps=ps.next;
        }
        return pl;
    }
    //用display函数来遍历我的链表
    public void display() {
        //创建一个临时节点cur来代替head
        ListNode cur = this.head;
        //如果想遍历整个链表，那条件必须是head==null。不能是head.next==null 这样最后一个节点无法遍历
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while (head != null) {
            if (head.val < x) {
                if (bs == null) {
                    bs = head;
                    be = head;
                } else {
                    be.next = head;
                    be = be.next;
                }

            } else {
                //判断向后插入是不是第一次
                if (as == null) {
                    as = head;
                    ae = head;
                } else {
                    ae.next = head;
                    ae = ae.next;
                }
                head = head.next;
            }
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            ae.next = null;
        }

        return bs;
    }

    //删除重复的链表节点
    public ListNode deleteDuplication() {
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;

        while(cur!=null){
            if (cur.next!=null && cur.val==cur.next.val) {
                while( cur.next!=null && cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return newHead.next;
    }





    //每次你写代码写不下去的地方，就是你要进步的地方
    public ListNode middleNode(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null && fast.next!=null){ //如果写成 fast.next!=null && fast!=null 会导致空指针异常。
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode findKthToTail(int k ){
        if(k<0 || this.head==null ){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1!=0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
