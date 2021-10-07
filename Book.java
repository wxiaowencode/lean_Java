package Book;

public class Book {
    public String name;//名字
    public String author;//作者
    public String price;//价格
    public String type;//类型
    public boolean isBorrowed;//状态

    public Book(String name, String author, String price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", " + ((isBorrowed == false)? "未借出":"已借出")+
                '}';
    }
}
