package operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍！");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要借阅的图书名字：");
        String name=scanner.nextLine();
        int currentSize=bookList.getUsedSize();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book=bookList.getBook(i);
            if(name.equals(book.getName()) ){

                book.setIsBorrowed(true);
                return;
            }
        }
        System.out.println("抱歉，没有这本书！！");
    }
}
