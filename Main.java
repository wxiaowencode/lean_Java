package user;

import Book.BookList;

import java.util.Scanner;

public class Main {
    public static User login(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的名字：");
        String name=scanner.nextLine();

        System.out.println("请输入你的身份：1->管理员  0->普通用户");
        int choice=scanner.nextInt();
        if(choice ==1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }



































    }
    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();//向上转型  发生动态绑定
        while(true){
            int choice=user.menu();
            //根据菜单的选项，来调用合适的方法！
            user.doOperation(choice,bookList);

        }



    }

}
