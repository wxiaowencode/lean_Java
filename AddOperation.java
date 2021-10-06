package operation;

import Book.Book;
import Book.BookList;


import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者：");
        String author = scanner.nextLine();

        System.out.println("请输入图书的类型：");
        String type = scanner.nextLine();
        System.out.println("请输入图书的价格：");
        String price = scanner.nextLine();


        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (name.equals(book.getName())) {
                System.out.println("书架里存在这本书，不能重复添加！！");
                System.out.println(book);
                return;
            }
        }

        Book book = new Book(name, author,price,type);
        bookList.setBooks(currentSize, book);
        bookList.setUsedSize(currentSize + 1);
        System.out.println("添加书籍成功!!!");
    }
}
