import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import static javafx.application.Platform.exit;


class List{
   public int n=10;
   public  int A[]=new int[n+1];
   public  int len;
}
class Lnode{
   public int data;
   public Lnode next;
}
class Linkqueue{
   public Lnode front;
    public Lnode rear;
}
public class QueueManagement {
    static long endTime,startTime,usedTime;
    static int n=3;//柜台个数
    static int vip1=0;//vip客户计数
   static int y,z;//y是得分，z是柜台号
   static float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0;
    static List l=new List();
    static Linkqueue q=new Linkqueue();
    static float i1=0,i2=0,i3=0,i4=0,i5=0;
  static   float ave1=0,ave2=0,ave3=0,ave4=0,ave5=0;
    public static void main(String[] args) throws InterruptedException {
        int x,v=0,w=0;//v办理业务的客户，w已办理完成的客户计数
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        ///System.out.println(dateFormat.format(date));
        System.out.println("**********************欢迎光临中国银行分行***************");
        System.out.println("                                                       ");
        System.out.println("                      1.顾客到达");
        System.out.println("                      2.顾客离开");
        System.out.println("                      3.查看业务办理");
        System.out.println("                      4.查看排队状况");
        System.out.println("                      5.系统查询");
        System.out.println("                      6.退出");
        System.out.println("                                                      ");
        System.out.println("              现在的时间："+dateFormat.format(date));
        System.out.println("                                                       ");
        System.out.println("                  提示：请按回车键进行下一步操作");
        System.out.println("*******************************************");
        System.out.println("请输入你的选择0-6：");
        int c=0;
        Scanner sc=new Scanner(System.in);
        c=sc.nextInt();
        switch (c){
            case 1:
                System.out.flush();
                System.out.println("****************顾客到达界面******************");
                int k=0,a=0;
                sc = new Scanner(System.in);
                System.out.println("请选择您的用户类型：1.VIP用户 2.普通用户");
                System.out.println("请输入：");
                a=sc.nextInt();
                if(a==1){
                    //调用vip函数
                    VIP(a);
                }else{
                    v++;
                    System.out.println("尊敬的普通用户，您的业务号为："+v);
                    arrive(v);
                    if(v==1){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==2){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    } else if(v==3){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==4){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==5){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==6){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==7){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==8){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==9){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==10){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else if(v==2){
                        startTime=System.currentTimeMillis();
                        System.out.println(startTime); //显示v=1的客户到达时间
                        Thread.sleep(2000);
                    }else{
                        System.out.println("请稍后拿号！");
                       Thread.sleep(1000);
                    }
                }
                System.out.flush();
                break;
            case 2:
                System.out.flush();
                System.out.println("******************顾客离开界面********************");
                System.out.println("请输入顾客离开的编号：");
                x=sc.nextInt();
                leave(x);
                myGrade();
                w++;
                if(x==1){
                 endTime=System.currentTimeMillis();
                 usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==2){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                } else if(x==3){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==4){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==5){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==6){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==7){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==8){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==9){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }else if(x==10){
                    endTime=System.currentTimeMillis();
                    usedTime=(endTime-startTime)/1000;
                    System.out.println("您办理业务所用的时间为："+usedTime);
                }
                System.out.flush();
                break;
            case 3:
                System.out.flush();
                System.out.println("*********************业务查询界面**************************");
                print1();
                System.out.flush();
                break;
            case 4:
                System.out.flush();
                System.out.println("*********************排队查询页面*********************************");
                print2();
                System.out.flush();
                break;
            case 5:
                System.out.flush();
                System.out.println("**********************系统查询界面********************************");
                char cool[]=new char[3];
                int i=0;
                int kz=0;
                System.out.println("请输入您的卡号：");
                Scanner src=new Scanner(System.in);
                i=src.nextInt();
                System.out.println("请输入您的五位密码：");
                int kl=0;
                while(cool[kz-1]!=' '){
                    cool[kz]=sc.next().charAt(kl);
                    kl++;
                    kz++;
                    System.out.print("*");
                }
                if(i==000 && cool[0]=='1' && cool[1]=='1' && cool[2]=='1' && cool[3]=='1'){

                   float allsum=sum1+sum2+sum3+sum4+sum5;
                   float average=allsum/w ;
                    System.out.println("至今已经有"+w+"位普通用户，"+vip1+"位vip用户成功办理了业务！");
                    System.out.println("普通用户办理共用时："+allsum);
                    System.out.println("vip用户业务办理共用时："+average);

                }
                System.out.flush();
                break;
            case 6:
                return;
            default:
                System.out.println("输入有误，请重新输入！");



        }
    }

    private static void print1() {
        int i;
        System.out.println("正在办理业务的顾客编号为:        一号柜台       二号柜台        三号柜台");
        System.out.println("                             ");
        for ( i = 1; i <l.len; i++) {
            System.out.println(l.A[i]+"号客户");
        }
    }
    private  static void print2(){
        int i=0;
        System.out.println("正在等候办理业务的顾客编号为：");
        Lnode s=q.front.next;
        while(s!=null){
            System.out.println(s.data);
            s=s.next;
            i++;
        }
        System.out.println("您面前一共有"+i+"人在排队，请您稍后!");
    }

    private static void myGrade() {
        System.out.println("为了改善服务质量，请您对我们的服务进行评价，谢谢！");
        z=counter();
        y=score();
        switch (z){
            case 1:
                sum1+=y;
                i1++;
                ave1=sum1/i1;
                System.out.println(z+"号柜台的满意度平均分为"+ave1+",感谢您的评分！谢谢！");
                break;
            case 2:
                sum2+=y;
                i3++;
                ave2=sum2/i2;
                System.out.println(z+"号柜台的满意度平均分为"+ave2+",感谢您的评分！谢谢！");
                break;
            case 3:
                sum3+=y;
                i3++;
                ave3=sum3/i3;
                System.out.println(z+"号柜台的满意度平均分为"+ave3+",感谢您的评分！谢谢！");
                break;
            default:
                System.out.println("您的输入有误！");
        }
    }

    private static int score() {
        int y=0;
        System.out.println("请输入您的评分：");
        System.out.println("1分----------非常不满意");
        System.out.println("2分----------非常不满意");
        System.out.println("3分----------非常不满意");
        System.out.println("4分----------非常不满意");
        System.out.println("5分----------非常不满意");
        System.out.println("请输入：");
        Scanner sc=new Scanner(System.in);
        y=sc.nextInt();
        if(y<1 || y>3){
            System.out.println("您输入的评分有误，请重新输入！");
            System.out.println("请输入您的评分：");
            y=sc.nextInt();
        }else{
            System.out.println("您的评分为："+y);
        }
        return y;
    }

    private static int counter() {
        int y=0;
        System.out.println("请输入您所办理的柜台号（1-3）：");
        Scanner sc=new Scanner(System.in);
        if(y<1 || y>3){
            System.out.println("您输入的柜台号有误，请重新输入！");
            System.out.println("请输入您所办理的柜台号（1-3）：");
            y=sc.nextInt();
        }else{
            System.out.println("您所办理的柜台业务为："+y);
        }
        return y;
    }

    private static void leave(int x) {
        int i=0,j=0;
        int y;
        do{
            if(x>l.len){
                System.out.println("输入有误！请重新输入！");
                Scanner sc=new Scanner(System.in);
                x=sc.nextInt();
                j++;
            }else{
                for (i=0;i<l.len;i++){
                    if(i==x){
                        System.out.println("尊敬的第"+x+"号顾客您好！");
                        l.A[i]=0;
                        l.len--;
                        if(q.front!=q.rear){
                            y=Dlquque(q);
                            l.A[i]=y;
                            l.len++;
                        }
                    }
                }
            }
        }while(i==0 && i<3);
        if(j==3){
            System.out.println("再见！下次光临！");
            System.exit(0);
        }
    }

    private static void Initarr(){
        int i;
        for(i=1;i<=n;i++){
            l.A[i]=0;
            l.len=0;
        }
    }
    private static int Dlquque(Linkqueue q) {
        //等待客户出列
        Lnode t=new Lnode();
        int x=0;
        if(q.front==q.rear){
            System.out.println("队列为空！");
            System.exit(0);
        }else{
            //等待客户t节点出对
            t=q.front.next;
            q.front.next=t.next;
            x=t.data;

        }
        return x;
    }
  private static void Initqueue(){
        q.front.next=null;
  }


    private static void arrive(int v) {
        int i=l.len+1;
        if(l.len<n){//如果数组l长度小于柜台个数n
            //将到达客户的客户号存入数组
            l.A[i]=v;
            i++;
            l.len++;
        }
        else Enqueue(q,v);
    }

    private static void Enqueue(Linkqueue q, int elem) {
        //elem进入等待客户等待队列
        Lnode s=new Lnode();
        s.data=elem;
        s.next=null;
        q.rear.next=s;
        q.rear=s;
    }

    //vip认证函数
    private static void VIP(int x) {
        int cardNumber=0;//卡号
        int a=x;
        int k=0;
        char ch[]=new char[3];
        switch (a){
            case 1:{
                System.out.println("请输入您的卡号：");
                Scanner sc=new Scanner(System.in);
                cardNumber=sc.nextInt();
                System.out.println("请输入您的五位密码：");
                int p=0;
                while(ch[k]!=' '){
                    ch[k]=sc.next().charAt(p);
                    p++;
                    k++;
                }
                if(cardNumber==100 && ch[0]=='1' && ch[1]=='1' && ch[2]=='1' && ch[3]=='1'){
                    System.out.println("尊敬的vip用户您好！请您直接到vip区办理业务！");
                    vip1++;
                }else if(cardNumber==200 && ch[0]=='2' && ch[1]=='2' && ch[2]=='2' && ch[3]=='2'){
                    System.out.println("尊敬的vip用户您好！请您直接到vip区办理业务！");
                    vip1++;
                }else if(cardNumber==300 && ch[0]=='3' && ch[1]=='3' && ch[2]=='3' && ch[3]=='3'){
                    System.out.println("尊敬的vip用户您好！请您直接到vip区办理业务！");
                    vip1++;
                }else if(cardNumber==400 && ch[0]=='4' && ch[1]=='4' && ch[2]=='4' && ch[3]=='4'){
                    System.out.println("尊敬的vip用户您好！请您直接到vip区办理业务！");
                    vip1++;
                }else if(cardNumber==500 && ch[0]=='5' && ch[1]=='5' && ch[2]=='5' && ch[3]=='5'){
                    System.out.println("尊敬的vip用户您好！请您直接到vip区办理业务！");
                    vip1++;
                }else System.out.println("您的输入有误！！");
                break;
            }
            default:
                break;
        }
    }



























}
