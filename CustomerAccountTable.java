import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;



class CustNode{
    public String name;
    public int serNumber;
    public int telNumber;
    public  CountNumNode countNode;
    public CustNode next;

    public CustNode(){

    }

    public CustNode(String name, int serNumber, int telNumber) {
        this.name = name;
        this.serNumber = serNumber;
        this.telNumber = telNumber;
    }
}
public class CustomerAccountTable {

    protected static void addCustomer(CustNode head, CustNode tempNode) {
        CustNode l1=new CustNode("李恒武",1,3423456);
        CustNode l2=new CustNode("李恒无",2,3423456);
        CustNode l3=new CustNode("李恒乌",3,3423456);
        CustNode l4=new CustNode("李恒悟",4,3423456);
        CustNode l5=new CustNode("李恒物",5,3423456);
        head.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        CustNode p=l5.next;
        while(p!=null){
            if(p.serNumber==tempNode.serNumber){
                System.out.println("流水号重复！");
                return;
            }
            p=p.next;
        }
        if(p==null){
            p=prior(head,p);
            tempNode.next=null;
            p.next=tempNode;
        }else {
            p=prior(head,p);
            tempNode.next=p.next;
            p.next=tempNode;
        }
    }

    private static CustNode prior(CustNode head, CustNode p) {
        CustNode temp=head;
        if(head.next==null) return head;
        while(temp.next ==null){
            temp=temp.next;
        }
        return  temp;
    }
      protected  static void deletCustomer(CustNode head,String name,int serNumber){
        CustNode p=head.next;
        if(head.next==null){
            System.out.println("该客户表中没有信息！查找失败！");
        }else{
            while(p.next!=null){
                if(name.equals(p.next.name) || serNumber==p.next.serNumber){
                    p=p.next.next;
                    System.out.println("删除成功！");
                    break;
                }else{
                    p=p.next;
                }
            }
        }
    }


    protected static CustNode createCustomerLink(){
        int seat=1;
       CustNode head=new CustNode("1",1,1);
       CountNumNode countNumNode=new CountNumNode(1,"1",1);
       String name=null;
       int telNumber,serNumber,countNumber;
       Scanner sc=new Scanner(System.in);
        System.out.println("请输入客户名字、电话、流水号、账号，建立客户信息表，以'-1'为结束标志");
        System.out.printf("请输入客户%d流水号(流水号必须在1到9999范围之内):",seat);
        serNumber=sc.nextInt();
        System.out.printf("请输入客户%d名字:",seat);
        name=sc.next();
        System.out.printf("请输入客户%d电话:",seat);
        telNumber=sc.nextInt();
        System.out.printf("请输入客户%d账号:",seat);
        countNumber=sc.nextInt();
        while(serNumber>0){
            seat++;
            CustNode temp=new CustNode();
            temp.countNode=countNumNode;
            temp.serNumber=serNumber;
            temp.telNumber=telNumber;
            temp.name=name;
            temp.countNode.countNumber=countNumber;
            addCustomer(head,temp);
            System.out.printf("请输入客户%d流水号(流水号必须在1到9999范围之内,且流水号一但输入不可修改！):",seat);
            serNumber=sc.nextInt();
            System.out.printf("请输入客户%d名字:",seat);
            name=sc.next();
            System.out.printf("请输入客户%d电话:",seat);
            telNumber=sc.nextInt();
            System.out.printf("请输入客户%d账号:",seat);
            countNumber=sc.nextInt();
        }
        return head;
    }
    public static void main(String[] args) {
        System.out.println("*************欢迎使用客户信息表***************");
        System.out.println("              1.客户表的建立");
        System.out.println("              2.添加客户信息");
        System.out.println("              3.删除客户信息");
        System.out.println("              4.修改客户信息");
        System.out.println("              5.查询客户信息");
        System.out.println("              6.退出信息表");
        System.out.println("*************欢迎使用客户信息表***************");
        System.out.println("请选择1-6:");
        boolean flg=false;
        CustNode head = new CustNode();
        while (true) {
            int x = 0;
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            switch (x) {
                default:
                    System.out.println("没有此功能，重新输入！");
                    break;
                case 1:
                    head = createCustomerLink();
                    System.out.println("建立客户表：");
                    printList(head);
                    flg=true;
                    break;
                case 2:
                    if(flg=true){
                        CustNode p=new CustNode();
                        int serNumber,telNumber;
                        String name;
                        System.out.println("请输入客户的流水号和姓名：");
                        System.out.println("请输入流水号（范围在1-9999之内）：");
                        serNumber=sc.nextInt();
                        p.serNumber=serNumber;
                        System.out.println("请输入姓名：");
                        name=sc.next();
                        p.name=name;
                        System.out.println("请输入电话号码：");
                        telNumber=sc.nextInt();
                        p.telNumber=telNumber;
                        addCustomer(head,p);
                        System.out.println("插入后：");
                        printList(head);
                    }else System.out.println("客户表还没有建立！请先建立客户表！");
                    break;
                case 3:
                    String name;
                    int serNumber;
                    System.out.println("请输入你要删除的客户名字：");
                    name=sc.next();
                    System.out.println("请输入你要删除的客户的流水号：");
                    serNumber=sc.nextInt();
                    deletCustomer(head,name,serNumber);
                    break;
                case  4:
                    int ser_Number = 0;//局部变量必须声明
                    System.out.println("请输入你要修改的客户的流水号（将依据流水号进行修改）：");
                  changeCustomer(head,ser_Number);
                    break;
                case 5:
                    int amountNumber=0;
                    System.out.println("请输入你要查询的客户流水号：");
                    amountNumber=sc.nextInt();
                    searchNumber(head,amountNumber);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void searchNumber(CustNode head, int countNumber) {
        CustNode temp=head.next;
        while(temp!=null){
            if(countNumber==temp.countNode.countNumber){
                System.out.println("该客户的名字是:"+temp.name);
                System.out.println("该客户的流水号是:"+temp.serNumber);
                System.out.println("该客户的电话是:"+temp.telNumber);
                System.out.println("该客户的余额是："+temp.countNode.balNumber);
                return;
            }else{
                temp=temp.next;
            }
        }
        System.out.println("没有找到！！");
    }

    protected static void changeCustomer(CustNode head,int serNumber){
        int g=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要修改的内容：1.客户名字 2.客户电话 3.客户账号");
        CustNode temp=head.next;
        if(head.next==null) {
            System.out.println("客户表中没有信息！");
            return;
        }
        g=sc.nextInt();
        while(temp!=null){
            if(serNumber==temp.serNumber){
                switch (g){
                    case 1:
                        String ss=null;
                        System.out.println("请输入修改后的客户名字：");
                        ss=sc.next();
                        temp.name=ss;
                        break;
                    case 2:
                        int q=0;
                        System.out.println("请输入修改后的客户电话：");
                        q=sc.nextInt();
                        temp.telNumber=q;
                        break;
                    case 3:
                        int z=0;
                        System.out.println("请输入修改后的客户账户：");
                        z=sc.nextInt();
                        temp.countNode.countNumber=z;
                        break;
                }
                System.out.println("修改成功！");
                return;
            }else{
                temp=temp.next;
            }
        }
        System.out.println("没有你要修改的客户！");
    }
    private static void printList(CustNode head) {
        CustNode temp=head.next;
        CountNumNode countNumNode=new CountNumNode(1,"1",1);
        head.countNode=countNumNode;
        System.out.println("---------------------------客户表----------------------------");
        System.out.println("    客户流水号      客户姓名       客户电话         客户账户   ");
        System.out.println("------------------------------------------------------------");
        if(head==null || head.next==null){
            System.out.println("职员表中没有信息！");
        }else{
            while(temp!=null){
                System.out.printf("%d         %s       %d       %d",temp.serNumber,temp.name,temp.telNumber,temp.countNode.countNumber);
                temp=temp.next;//bug1:只能打印222，第一位客户打印不出来
            }
        }
        System.out.println("\n-------------------------------------------------------------");
    }
}
