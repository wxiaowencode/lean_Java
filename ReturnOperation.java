package operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍！");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要归还的图书名字：");
        String name=scanner.nextLine();
        int currentSize=bookList.getUsedSize();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book=bookList.getBook(i);
            if(name.equals(book.getName())){

                book.setIsBorrowed(false);
                System.out.println("归还成功！！！");
                return;
            }
        }
    }
}
