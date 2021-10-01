public class Test {
        public static ListNode mergeTwoLists( ListNode headA, ListNode headB) {
                ListNode newHead=new ListNode();
                ListNode tmp=newHead;
                while(headA !=null && headB !=null){
                        if(headA.val<headB.val){
                                tmp.next=headA;
                                headA=headA.next;
                                tmp=tmp.next;
                        }else{
                                tmp.next=headB;
                                headB=headB.next;
                                tmp=tmp.next;
                        }
                }
                if(headA !=null){
                        tmp.next=headA;
                }
                if (headB!=null){
                        tmp.next=headB;
                }

                return newHead.next;
        }
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                ListNode pl = headA;
                ListNode ps = headB;
                //求的两个链表的长度
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
                pl = headA;
                ps = headB;
                int len = lenA - lenB;
                if(len < 0) {
                        pl = headB;
                        ps = headA;
                        len = lenB-lenA;
                }
                while (len != 0) {
                        pl = pl.next;
                        len--;
                }
                while (pl != ps) {
                        pl = pl.next;
                        ps = ps.next;
                }
                if(pl == null) {
                        return null;//没有交点
                }
                return pl;
        }
public static void main(String[]args){





        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.display();
        int ret= myLinkedList.size();
        System.out.println(ret);


   }
}
