import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

class BusinessNode{
    public int num;
    public int credit;
    public String personStable;
    public int window;
    public String startTime;
    public String endTime;
    public int  type;
    public int price;
    public BusinessNode next;
    public BusinessNode(){

    }
    public BusinessNode(int credit, String personStable, int window, String startTime,String endTime, int type, int price) {
        this.credit = credit;
        this.personStable = personStable;
        this.window = window;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.price = price;
    }
}
public class BusinessQuery {
    public static void main(String[] args) {
        System.out.println("*************航班信息查询与检测系统************");
        System.out.println("              1.按个人信用积分查询   ");
        System.out.println("              2.按业务稳定性");
        System.out.println("              3.按窗口查询   ");
        System.out.println("              4.按开始办理业务时间查询   ");
        System.out.println("              5.按结束办理业务时查询   ");
        System.out.println("              6.按业务类型查询   ");
        System.out.println("              7.按收费额度查询   ");
        System.out.println("              0.退出系统   ");


        //输入航班记录   调用函数
        BusinessNode head=new BusinessNode();
        head=InputMessage();
        int a=0;
        System.out.println("请输入你要选择的功能（0-7）：");
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        switch (a){
            default:
                System.out.println("您的输入有误！请重新输入！");
                break;
            case 1:
                searchCredit(head);
                break;
            case 2:
                searchStable(head);
                break;
            case 3:
                searchWindow(head);
                break;
            case 4:
                searchStartTime(head);
                break;
            case 5:
                searchEndTime(head);
                break;
            case 6:
                searchType(head);
                break;
            case 7:
                searchPrice(head);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    private  static void searchCredit(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的信誉积分：");
        int credit=0;
        credit=sc.nextInt();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.credit==credit){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private  static void searchStable(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的业务稳定性：");
        String personStable=null;
        personStable=sc.next();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.personStable.equals(personStable)){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private  static void searchWindow(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的窗口：");
        int window=0;
        window=sc.nextInt();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.window==window){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private  static void searchStartTime(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的业务开始时间：");
        String startTime=null;
        startTime=sc.next();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.startTime.equals(startTime)){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private  static void searchEndTime(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的业务结束时间：");
        String endTime=null;
        endTime=sc.next();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.endTime.equals(endTime)){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private  static void searchType(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的业务类型：");
        int type=0;
        type=sc.nextInt();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.type==type){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private  static void searchPrice(BusinessNode head){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要查询的收费额度：");
        int price=0;
        price=sc.nextInt();
        BusinessNode temp=new BusinessNode();
        temp=head.next;
        if(head==null || head.next==null){
            System.out.println("无信息可查询！");
        }
        int n=1;
        while(temp!=null){
            if(temp.price==price){
                System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
                System.out.println("找到了第"+n+"条符合的业务信息！");
                System.out.println("个人信用积分："+temp.num);
                System.out.println("业务稳定性（个人）："+temp.personStable);
                System.out.println("办理窗口："+temp.window);
                System.out.println("开始办理时间："+temp.startTime);
                System.out.println("结束办理时间："+temp.endTime);
                System.out.println("业务类型："+temp.type);
                System.out.println("收费额度："+temp.price);
                temp=temp.next;
                n++;
            }else{
                temp=temp.next;
            }
        }
    }
    private static BusinessNode InputMessage() {
        Scanner sc=new Scanner(System.in);
        BusinessNode head=new BusinessNode();
        System.out.println("请依次录入业务信息数据(业务号由2个字母和4个数字组成)：");
        System.out.println("业务号 个人信用积分 业务稳定性（个人） 办理窗口 开始办理时间 结束办理时间 业务类型 收费额度");
        String personStable,startTime,endTime;
        int credit,window,type,price,num;
        boolean flg=true;
        System.out.println("请输入业务号：");
        num=sc.nextInt();
        System.out.println("请输入个人信用积分（90-100之间）：");
        credit=sc.nextInt();
        System.out.println("请输入业务稳定性（强、一般、弱）：");
        personStable=sc.next();
        System.out.println("请输入办理窗口（1-5之间）：");
        window=sc.nextInt();
        System.out.println("请输入开始办理时间：");
        startTime=sc.next();
        System.out.println("请输入结束办理时间：");
        endTime=sc.next();
        System.out.println("请输入业务类型（1-5）之间：1.贷款 2.存款 3.取款 4.利息业务 5.负债业务");
        type=sc.nextInt();
        System.out.println("请输入收费额度（1-100）：");
        price=sc.nextInt();
     String c=null;
        while(flg){
            BusinessNode temp=new BusinessNode();
            temp.num=num;
            temp.credit=credit;
            temp.personStable=personStable;
            temp.window=window;
            temp.startTime=startTime;
            temp.endTime=endTime;
            temp.type=type;
            temp.price=price;
            insertYouYo(head,temp);
            System.out.println("是否继续输入？（Y/N）");
            c=sc.next();
            if(c.equals("Y")){
            }else {
                flg=false;
                break;
            }
            System.out.println("请输入业务号：");
            num=sc.nextInt();
            System.out.println("请输入个人信用积分（90-100之间）：");
            credit=sc.nextInt();
            System.out.println("请输入业务稳定性（强、一般、弱）：");
            personStable=sc.next();
            System.out.println("请输入办理窗口（1-5之间）：");
            window=sc.nextInt();
            System.out.println("请输入开始办理时间：");
            startTime=sc.next();
            System.out.println("请输入结束办理时间：");
            endTime=sc.next();
            System.out.println("请输入业务类型（1-5）之间：1.贷款 2.存款 3.取款 4.利息业务 5.负债业务");
            type=sc.nextInt();
            System.out.println("请输入收费额度（1-100）：");
            price=sc.nextInt();
        }
        return head;
    }

    private static void insertYouYo(BusinessNode head, BusinessNode tempNode) {
        BusinessNode b1=new BusinessNode(97,"一般",4,"20200212","20200305",2,34);
        BusinessNode b2=new BusinessNode(96,"强",2,"20201215","20201213",5,67);
        BusinessNode b3=new BusinessNode(99,"弱",5,"20200405","2020113",1,2234);
        BusinessNode b4=new BusinessNode(98,"强",2,"20200405","2020113",2,2234);
        BusinessNode b5=new BusinessNode(89,"强",2,"20200405","2020113",1,2234);
        BusinessNode b6=new BusinessNode(98,"一般",2,"20200405","2020113",3,2234);
        BusinessNode b7=new BusinessNode(97,"强",3,"20200405","2020113",1,2234);
        BusinessNode b8=new BusinessNode(96,"强",2,"20200405","2020113",4,2234);
        BusinessNode b9=new BusinessNode(95,"一般",3,"20200405","2020113",1,2234);
        BusinessNode b10=new BusinessNode(69,"强",2,"20200405","2020113",5,2234);
        BusinessNode b11=new BusinessNode(97,"弱",3,"20200405","2020113",4,2234);
        head.next=b1;
        b1.next=b2;
        b2.next=b3;
        b3.next=b4;
        b4.next=b5;
        b5.next=b6;
        b6.next=b7;
        b7.next=b8;
        b8.next=b9;
        b9.next=b10;
        b10.next=b11;
        BusinessNode p=b11.next;
        while(p!=null){
            p=p.next;
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

    private static BusinessNode prior(BusinessNode head, BusinessNode p) {
       BusinessNode temp = head;
        if (head.next == null) return head;
        while (temp.next != p) temp = temp.next;
        return temp;
    }
}
