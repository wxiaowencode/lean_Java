import java.util.Scanner;



class CustNode{
    private String name;
    private int serNumber;
    private int telNumber;
    public  CountNumNode countNode;
    public CustNode next;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerNumber() {
        return serNumber;
    }

    public void setSerNumber(int serNumber) {
        this.serNumber = serNumber;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }
}
public class CustomerAccountTable {

    protected static void addCustomer(CustNode head, CustNode tempNode) {

    }
    protected static CustNode createCustomerLink{
       CustNode head=new CustNode();
       String name=null;
       int telNumber,serNumber,countNumber;
       Scanner sc=new Scanner(System.in);
        System.out.println("请输入客户名字、电话、流水号、账号，建立客户信息表，以'-1'为结束标志");
        System.out.println("请输入客户流水号:");
        serNumber=sc.nextInt();
        System.out.println("请输入客户名字:");
        name=sc.next();
        System.out.println("请输入客户电话:");
        telNumber=sc.nextInt();
        System.out.println("请输入客户账号:");
        countNumber=sc.nextInt();
        while(serNumber>0){
            CustNode temp=new CustNode();
            temp.setSerNumber(serNumber);
            temp.setTelNumber(telNumber);
            temp.setName(name);
            temp.countNode.setCountNumber(countNumber);
            addCustomer(head,temp);
        }
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
        System.out.println("请选择1-6");
        while(true){
            int x=0;
            Scanner sc=new Scanner(System.in);
            x=sc.nextInt();
            switch (x){
                default:
                    System.out.println("没有此功能，重新输入！");
                    break;
                case 1:
                    break;
            }
        }
    }
}
