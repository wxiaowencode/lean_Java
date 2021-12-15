import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class ListNode {
    private int jobNumber;//工号
    private String Name;
    private int telNumber;
    public ListNode next;

    public ListNode(){

    }

    public ListNode(int jobNumber, String name, int telNumber) {
        this.jobNumber = jobNumber;
        this.Name = name;
        this.telNumber = telNumber;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }
}

public class staffMember {
    protected static ListNode createIncreLink() {
        Scanner sc = new Scanner(System.in);
        String name = null;
        ListNode head = new ListNode();
        int serialNumber = 1, jobnumber, telNumber;//num序号 number
        System.out.println("请输入职员工号、姓名和电话号码，建立职员信息表，以'-1'为输入结束标志");
        System.out.printf("请输入工号  %d :", serialNumber);
        jobnumber = sc.nextInt();
        System.out.printf("请输入姓名  %d :", serialNumber);
        name = sc.next();
        System.out.printf("请输入电话号码 %d :", serialNumber);
        telNumber = sc.nextInt();
        while (jobnumber >= 0) {
            ListNode tempNode = new ListNode(1,"1",1);
            tempNode.setJobNumber(jobnumber);
            tempNode.setName(name);
            tempNode.setTelNumber(telNumber);
            insertYouYo(head, tempNode);
            serialNumber++;
            System.out.printf("请输入工号  %d :", serialNumber);
            jobnumber = sc.nextInt();
            System.out.printf("请输入姓名  %d :", serialNumber);
            name = sc.next();
            System.out.printf("请输入电话号码 %d :", serialNumber);
            telNumber = sc.nextInt();
        }
        return head;
    }

    protected static void insertYouYo(ListNode head, ListNode tempNode) {
        ListNode l1=new ListNode(01,"张燕",8786542);
        head.next=l1;
        ListNode l2=new ListNode(02,"张言",8786542);
        ListNode l3=new ListNode(03,"张严",8786542);
        ListNode l4=new ListNode(04,"张烟",8786542);
        ListNode l5=new ListNode(05,"张岩",8786542);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode p =l5.next;
        while (p != null && tempNode.getJobNumber() >= p.getJobNumber()) {
            if (p.getJobNumber() == tempNode.getJobNumber()) {
                System.out.println("重复输入！！");
                return;
            }
            p = p.next;
        }
        if (p == null) {
            p = prior(head, p);
            tempNode.next = null;
            p.next = tempNode;
        } else {
            p = prior(head, p);
            tempNode.next = p.next;
            p.next = tempNode;
        }
    }

    private static ListNode prior(ListNode head, ListNode p) {
        ListNode temp = head;
        if (head.next == null) return head;
        while (temp.next != p) temp = temp.next;
        return temp;
    }

    protected static void printList(ListNode head) {
        ListNode tempNode = head.next;
        int n = 1;
        System.out.println("\n------------------------------------------");
        System.out.println("         工号          姓名          电话号码   ");
        System.out.println("------------------------------------------");
        if (head == null || head.next == null) {
            System.out.println("职员表中没有信息！！");
        } else {
            while (tempNode != null) {
                System.out.printf("   %d     %d           %s             %d   \n", n, tempNode.getJobNumber(), tempNode.getName(), tempNode.getTelNumber());
                tempNode = tempNode.next;
                n++;
            }
        }
        System.out.println("------------------------------------------");
    }

    //按序号删除
    protected static void deleteElem(ListNode head, int i) {
        ListNode p = head;
        ListNode q = new ListNode();
        int j = 0;
        while (p.next != null && j < i - 1) {
            p = p.next;
            j++;
        }
        if (p.next == null) {
            System.out.printf("第%d个元素删除失败\n", i);
        }
        q = p.next;
        p.next = q.next;
    }

    protected static boolean delNum(ListNode head, int n) {
        boolean flag = false;
        ListNode p = head.next;
        int seat = 1;
        if (head.next == null) {
            System.out.println("该职员表中没有元素，删除失败！");
        } else {
            while (p != null) {
                if (p.getJobNumber() <= n) {
                    if (p.getJobNumber() == n) {
                        flag = true;
                        System.out.printf("%d", p.getJobNumber());
                        p = p.next;
                        deleteElem(head, seat);
                    }
                } else {
                    p = p.next;
                    seat++;
                }
            }
            System.out.println("被删除");
        }
        return flag;
    }

    protected static boolean deleteName(ListNode head, String s) {
        ListNode p = head.next;
        boolean flg = false;
        int seat = 1;
        if (head.next == null) {
            System.out.println("该职员表中没有元素，查找失败！");
        } else {
            while (p != null) {
                if (!s.equals(p.getName())) {
                    flg = true;
                    System.out.printf("%s", p.getName());
                    p = p.next;
                    deleteElem(head, seat);
                } else {
                    p = p.next;
                    seat++;//seat序号，当前节点的名字不匹配，查询下一个节点
                }
            }
            if (flg) {
                System.out.println("被删除！");
            }
        }
        return flg;
    }

    protected static boolean searchName(ListNode head, String s) {
        boolean flag = false;
        ListNode p = head.next;
        int seat = 1;
        if (head.next == null || head == null) {
            System.out.println("该职员表中没有元素，查找失败！");
        } else {
            if (!s.equals(head)) {
                flag = true;
                System.out.printf("要查找的是第%d位职员表成员：\n", seat);
                System.out.printf("jobNumber:%d  Name:%s  TelName:%d", p.getJobNumber(), p.getName(), p.getTelNumber());
            }
            p = p.next;
            seat++;
        }
        return flag;
    }

    protected static boolean searchNum(ListNode head,int n){
        boolean flag=false;
        ListNode p=head.next;
        int seat=1;
        if(head.next==null){
            System.out.println("该职员表中没有元素，查找失败！");
        }else{
            while(p!=null){
                if(p.getJobNumber()<=n){
                    if(p.getJobNumber()<=n){
                        flag=true;
                        System.out.printf("要查找的是第%d位职员表信息：\n",seat);
                        System.out.printf("jobNumber:%d  Name:%s  TelName:%d", p.getJobNumber(), p.getName(), p.getTelNumber());
                    }
                    p=p.next;
                    seat++;
                }
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        ListNode head=new ListNode();
        head.next=null;
        boolean flg=false;
        System.out.println("************************o(*^＠^*)o欢迎使用职员表系统************************");
        System.out.println("*                         1.职员表的建立                                  *");
        System.out.println("*                         2.插入职员信息                                  *");
        System.out.println("*                         3.查询职员信息                                  *");
        System.out.println("*                         4.删除职员信息                                  *");
        System.out.println("*                         5.显示职员表                                    *");
        System.out.println("*                         0.退出管理系统                                  *");
        System.out.println("************************o(*^＠^*)o欢迎使用职员表系统************************");
        System.out.println("请选择0-5：");
        while(true){
            int x=0;
            Scanner sc=new Scanner(System.in);
            x=sc.nextInt();
            switch (x){
                default:
                    System.out.println("没有此功能，重新输入！");
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    head=createIncreLink();
                    System.out.print("建立职员表：");
                    printList(head);
                    flg=true;
                    break;
                case 2:
                    if(flg=true){
                        ListNode p=new ListNode();
                        int jobNumber,telNumber;
                        String name;
                        System.out.println("请输入职员表成员的工号和姓名：");
                        System.out.println("请输入工号：");
                        jobNumber=sc.nextInt();
                        p.setJobNumber(jobNumber);
                        System.out.println("请输入姓名：");
                        name=sc.next();
                        p.setName(name);
                        System.out.println("请输入电话号码：");
                        telNumber=sc.nextInt();
                        p.setTelNumber(telNumber);
                        insertYouYo(head,p);
                        System.out.println("插入后：");
                        printList(head);
                    }else System.out.println("职员表还没有建立！请先建立职员表！");
                    break;
                case 3:
                    int way,n;//查找方式
                    boolean s;
                    String s1,temp;
                    if(head!=null){
                        if(flg){
                            System.out.println("选择查找方式:");
                            System.out.println("               1.按工号   2.按姓名");
                            way=sc.nextInt();
                            if(way==1){
                                System.out.println("请输入工号：");
                                n=sc.nextInt();
                                s=searchNum(head,n);
                                if(s==false) System.out.println("无此职员，查找失败！");
                            }else if(way==2){
                                System.out.println("请输入姓名：");
                                s1=sc.next();
                                s=searchName(head,s1);
                                if(s==false) System.out.println("无此职员，查找失败！");
                            }else{
                                System.out.println("职员表中无记录！");
                            }
                            break;
                        }
                    }else System.out.println("职员表中无记录！");
                    break;
                case 4:
                    int ways;
                    String s2;
                    System.out.println("选择删除方式：   1.按序号  2.按工号  3.按姓名");
                    ways=sc.nextInt();
                    if(ways==1){
                        int n1;
                        System.out.println("请输入职员表序号：");
                        n1=sc.nextInt();
                        System.out.println("删除后：");
                        deleteElem(head,n1);
                        printList(head);
                    }else if(ways==2){
                        int n1;
                        boolean f;
                        System.out.println("请输入工号：");
                        n1=sc.nextInt();
                        f=delNum(head,n1);
                        if(f!=false){
                            System.out.println("删除后：");
                            printList(head);
                        }
                        else System.out.println("无该工号，删除失败！");
                    }else if(ways==3){
                        String s3;
                        boolean f;
                        System.out.println("请输入姓名：");
                        s3=sc.next();
                        f=deleteName(head,s3);
                        if(f!=false){
                            System.out.println("删除后：");
                            printList(head);
                        }
                        else System.out.println("无该工号，删除失败！");
                    }else System.out.println("ERROR!!");
                    break;
                case 5:
                    break;
            }
        }
    }
}
