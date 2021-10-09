package operation;

import Book.Book;
import Book.BookList;

public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示书籍！");
        int currentSize=bookList.getUsedSize();
        for (int i = 0; i <currentSize; i++) {
            Book book=bookList.getBook(i);
            System.out.println(book);
        }
    }
}
