//package tk.ewentsai.manage;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import tk.ewentsai.pojo.Book;
//import tk.ewentsai.pojo.eBook;
//
//import java.util.ArrayList;
//
//public class manageBook {
//
//    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//    private static BookServiceImpl BookBean = applicationContext.getBean("bookService",BookServiceImpl.class);
//    private static eBookServiceImpl EBookBean = applicationContext.getBean("eBookService", eBookServiceImpl.class);
//    private static OrdersServiceImpl OrdersBean = applicationContext.getBean("ordersService",OrdersServiceImpl.class);
//
//    //根据书本的id号拿到对应的book对象
//    public static Book searchID(int id) { return BookBean.FindById(id); }
//
//    public static ArrayList<Book> searchName(String bookName){ return BookBean.FindByName(bookName); }
//
////    public static ArrayList<eBook> getEBook(){ return EBookBean.getAll(); }
//
//    public static ArrayList<Book> getBooks() { return BookBean.selAll(); }
//
//    public static ArrayList<eBook> geteBooks() { return EBookBean.getAll(); }
//
//    public static ArrayList getBooks(String bookClass){
//        ArrayList list = new ArrayList();
//        switch (bookClass){
//            case "newBook":
//                list = getBooks();
//                break;
//            case "eBook":
//                list = geteBooks();
//                break;
//        }
//        return list;
//    }
//}
