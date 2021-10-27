/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-04-27
 * Time: 16:43
 */
public class TestDemo {


    public static void main(String[] args) {
        TestLinkedList testLinkedList = new TestLinkedList();
        testLinkedList.addLast(1);
        testLinkedList.addLast(2);
        testLinkedList.addLast(3);
        testLinkedList.addLast(4);
        testLinkedList.display();
    }


    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode();//傀儡节点
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if(headA.val < headB.val) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //0、分别定义一个pl和ps来指定最长和最短的链表
        //我假设刚开始的时候，pl指向的是最长的
        ListNode pl = headA;
        ListNode ps = headB;
        //1、别求的两个链表的长度
        int lenA = 0;
        int lenB = 0;
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        //重点：因为为了求长度 这两个引用都是null了。
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB-lenA;
        }
        //2.pl指向的链表一定是最长的！！！！  len一定是那个长度差

        //3、让pl所指向的链接走len步

        while (len != 0) {
            pl = pl.next;
            len--;
        }
        //4、同时走 pl==ps==null
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        if(pl == null) {
            return null;//没有交点
        }
        return pl;
    }

    public static void creteCut(ListNode headA, ListNode headB) {
        headB.next.next = headA.next.next;
    }

    public static void main3(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(3);
        myLinkedList.addLast(36);
        myLinkedList.addLast(10);
        myLinkedList.display();

        myLinkedList.createLoop();

        boolean ret = myLinkedList.hasCycle();
        System.out.println(ret);

        ListNode node = myLinkedList.detectCycle();
        System.out.println(node.val);
    }



    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(3);
        myLinkedList.addLast(36);
        myLinkedList.addLast(1);
        myLinkedList.display();

        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(1);
        myLinkedList2.addLast(6);
        myLinkedList2.addLast(8);
        myLinkedList2.addLast(14);
        myLinkedList2.addLast(34);
        myLinkedList2.display();


        creteCut(myLinkedList.head,myLinkedList2.head);
        ListNode ret = getIntersectionNode(myLinkedList.head,myLinkedList2.head);
        if(ret == null) {
            System.out.println("没有相交!");
        }else {
            System.out.println(ret.val);
        }


       /* ListNode ret = mergeTwoLists(myLinkedList.head,myLinkedList2.head);
        myLinkedList2.display2(ret);*/

       /* System.out.println("===============");

        ListNode ret = myLinkedList.findKthToTail(4);
        System.out.println(ret.val);*/

        /*ListNode ret = myLinkedList.reverseList();
        myLinkedList.display2(ret);*/
        /*myLinkedList.removeAllKey(1);
        myLinkedList.display();//*/
        /*boolean ret = myLinkedList.contains(11);
        System.out.println(ret);*/
    }
}
