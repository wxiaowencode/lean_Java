import netscape.javascript.JSUtil;

import java.util.Map;
import java.util.Scanner;

public class SpecificBusiness {
    static double rate=0;//利率
    static int loanAmount=0,loanCount=0,loanTime=0,beforeloan=0,deposittime; //贷款账户，贷款金额，贷款利率。
    public static void main(String[] args) {
        System.out.println("*************具体业务实现***********");
        System.out.println("             1.存款");
        System.out.println("             2.取款");
        System.out.println("             3.贷款");
        System.out.println("             4.利息计算");//贷款要归还的利息   放在银行应得的利息
        System.out.println("             5.查询账户余额");
        System.out.println("***********************************");
        CustNode head=new CustNode();
        int x=0;
        System.out.println("请选择业务操作1-5：");
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        switch (x){
            case 1:
                int count=0,amount=0;
                System.out.println("请输入你要存款的账户：");
                amount=sc.nextInt();
                System.out.println("请输入你要存款的金额（单位: 元）：");
                count=sc.nextInt();
                System.out.println("请输入你要存款的期限：");
                deposittime=sc.nextInt();
                depositMoney(head,amount,count);
                break;
            case 2:
                int withdrawCount=0,amount_w;
                System.out.println("请输入你要取款的账户：");
                amount_w=sc.nextInt();
                System.out.println("请输入你要取款的金额（单位:元）：");
                withdrawCount=sc.nextInt();
                withdrawMoney(head,amount_w,withdrawCount);
                break;
            case 3:
                System.out.println("请输入你的贷款账户：");
                loanAmount=sc.nextInt();
                System.out.println("请输入你的贷款金额：");
                loanCount=sc.nextInt();
                System.out.println("请输入你的贷款期限(单位:期数（一期一个季度)：");
                loanTime=sc.nextInt();
                loanMoney(head,loanAmount,loanCount,loanTime);
                break;
            case 4:
                int c=0,repayAmount=0;
                System.out.println("请输入你要计算利息的账户：");
                repayAmount=sc.nextInt();
                System.out.println("选择你要计算的利息：1.贷款应归还的利息 2.存款应得利息 3.综合利息");
                double result=0;
                if(c==1){
                   result= loanRepayInterest(head,repayAmount);
                }else if(c==2){
                   result= depositRepayInterest(head,repayAmount);
                }else if(c==3){
                    result=allRepayInterest(head,repayAmount);
                }
                break;
            case 5:
                int findAmount=0;
                System.out.println("请输入要查询的账户：");
                findAmount=sc.nextInt();
                CustNode temp=head.next;
                boolean flg=false;
                while (temp!=null){
                    if(findAmount==temp.countNode.countNumber){
                        flg=true;
                        System.out.println("该账户的余额为:"+temp.countNode.balNumber);
                    }else{
                        temp=temp.next;
                    }
                }
                if(flg==false) System.out.println("该账户不存在！");
                break;
        }
    }
    private static double allRepayInterest(CustNode head,int repayAmount){
        double result=0;
        double a=loanRepayInterest(head,repayAmount);
        double b=depositRepayInterest(head,repayAmount);
        result=Math.max(a,b)- Math.min(a,b);
        return result;
    }
    private static double loanRepayInterest(CustNode head,int repayAmount){
        double result=0;
        //判断该账户是否贷过款
        CustNode temp=head.next;
        boolean flg=false;
        while(temp!=null){
            if(repayAmount==temp.countNode.countNumber){
                flg=true;
                if(temp.countNode.isLoan==false){
                    System.out.println("该账户没有贷过款！无法计算！");
                }
            }else{
                temp=temp.next;
            }
        }
        if(flg=false){
            System.out.println("该账户不存在！");
        }
        result=loanCount*rate*loanTime*1.0;
        return result;
    }
    private static double depositRepayInterest(CustNode head,int repayAmount){
        double result=0;
        CustNode temp=head.next;
        boolean flg=false;
        while(temp!=null){
            if(repayAmount==temp.countNode.countNumber){
                flg=true;
                if(temp.countNode.isLoan==false){
                    System.out.println("该账户没有贷过款！无法计算！");
                }
            }else{
                temp=temp.next;
            }
        }
        if(flg=false){
            System.out.println("该账户不存在！");
        }
        result=beforeloan*0.2*deposittime*1.0;
        return result;
    }
    private static void loanMoney(CustNode head,int loanAmount,int loanCount,int loanTime){
        CustNode temp=head.next;
        boolean flg=false;
        while(temp!=null){
            if(temp.countNode.countNumber==loanAmount){
                flg=true;
                beforeloan=temp.countNode.balNumber;
                temp.countNode.balNumber+=loanCount;
                temp.countNode.isLoan=true;
            }else{
                temp=temp.next;
            }
        }
        if(flg==false){
            System.out.println("该账户不存在！！");
        }
        int chase=0;
        System.out.println("请选择你的贷款利率类型：1.12%  2.13%   3.14%");
        switch (chase){
            case 1:
                rate=0.12;
                break;
            case 2:
                rate=0.13;
                break;
            case 3:
                rate=0.14;
                break;
        }
        System.out.println("贷款成功！");
    }





    private static void withdrawMoney(CustNode head, int amount_w, int withdrawCount) {
        CustNode temp=head.next;
        if(head.next==null){
            System.out.println("找不到该账户！");
        }
        while(temp!=null){
            if(amount_w==temp.countNode.countNumber){
                temp.countNode.balNumber-=withdrawCount;
                System.out.println("取款成功！");
                return;
            }else{
                temp=temp.next;
            }
        }
        System.out.println("该账户不存在！");
    }

    private static void depositMoney(CustNode head,int amount, int count) {
        CustNode temp=head.next;
        if(head.next==null){
            System.out.println("该账户不存在！");
        }
        while(temp!=null){
            if(amount==temp.countNode.countNumber){
                temp.countNode.balNumber+=count;
                System.out.println("存款成功！");
               return;
            }else{
                temp=temp.next;
            }
        }
        System.out.println("该账户不存在！！");
    }
}
