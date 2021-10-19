package user;

import operation.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.iOperations=new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }
    public int menu(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("========管理员菜单=======");
        System.out.println("hello"+super.name+"欢迎来到90年代！");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("=======================");

        int choice=scanner.nextInt();
        return choice;
    }
}
