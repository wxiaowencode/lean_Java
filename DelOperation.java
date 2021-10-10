package operation;

import Book.Book;
import Book.BookList;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        System.out.println("删除书籍！");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要删除的图书名字：");
        String name=scanner.nextLine();
        int currentSize=bookList.getUsedSize();
        int index=-1;
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book=bookList.getBook(i);
            if(name.equals(book.getName())){

                index=i;
            }
    }
        if(index==-1){
            System.out.println("没有你要删除的这本书！！！");
            return;
        }

        for (int i = index; i <currentSize-1 ; i++) {
            Book book1=bookList.getBook(i+1);
            bookList.setBooks(i,book1);
        }

        //防止内存泄漏
        bookList.setBooks(currentSize-1,null);
        //控制usedSize
        bookList.setUsedSize(currentSize-1);



        System.out.println("删除成功！！");
        }


     }

