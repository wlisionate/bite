package bite08;

import java.util.Comparator;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 10:48
 * @Description:
 */
public class Book implements Comparator<Book> {
    String ISBN;
    String name;
    String auther;

    @Override
    public int compare(Book o1, Book o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        //1.先进行判空操作
        if(obj == null){
            return false;
        }
        //2.判断obj指向的对象是否是Book
        if(!(obj instanceof  Book)){
            return false;
        }
        //3.先向下进行转型
        Book book = (Book)obj;
        //4.根据需要，进行判断
        return this.ISBN.equals(book.ISBN);
    }

    public static void main(String[] args) {
        Book book = new Book();
        Book book1 = new Book();
        book.ISBN = "123";
        book.name = "000";
        book.auther = "000";
        book1.ISBN = "123";
        book1.name = "000";
        book1.auther = "000";
        System.out.println(book == book1);
        System.out.println(book.equals(book1));
    }

//    @Override
//    public int compareTo(Book o) {
//        return this.name.compareTo(o.name);
//    }
}
