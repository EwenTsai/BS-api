package tk.ewentsai.unit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.ewentsai.dao.OrdersServiceImpl;
import tk.ewentsai.pojo.PageBean;

public class pagination {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
    private static BookServiceImpl BookBean = applicationContext.getBean("bookService",BookServiceImpl.class);
    private static eBookServiceImpl EBookBean = applicationContext.getBean("eBookService", eBookServiceImpl.class);
    private static OrdersServiceImpl OrdersBean = applicationContext.getBean("ordersService",OrdersServiceImpl.class);

    //分页显示
    public static PageBean findPageBean(int CurrPage, String bookClass){
        PageBean pb = new PageBean<>(CurrPage);
        // 封装当前页数到pb对象
        switch (bookClass){
            case "newBook":
                pb.setList(BookBean.paginationBook((CurrPage-1)*10));
                break;
            case "eBook":
                pb.setList(EBookBean.paginationBook((CurrPage-1)*10));
                break;
            case "orders":
                pb.setList(OrdersBean.paginationOrders((CurrPage-1)*10));
        }
        return pb;
    }
}
