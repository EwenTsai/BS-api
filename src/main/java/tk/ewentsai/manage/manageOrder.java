//package tk.ewentsai.manage;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import tk.ewentsai.pojo.Book;
//import tk.ewentsai.pojo.singalOrder;
//import tk.ewentsai.pojo.Orders;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//
//public class manageOrder {
//
//    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//    private static OrdersServiceImpl OrdersBean = applicationContext.getBean("ordersService",OrdersServiceImpl.class);
//    private static OrderServiceImpl OrderBean = applicationContext.getBean("orderService",OrderServiceImpl.class);
//    private static CartServiceImpl cartBean = applicationContext.getBean("cartService",CartServiceImpl.class);
//
//    public static ArrayList<Orders> getOrdersByUid(int uid){ return OrdersBean.getOrdersByUid(uid); }
//    public static ArrayList<Orders> getOrders(){ return OrdersBean.getAllOrders(); }
//
//    public static void addOrders(int uid, int number, BigDecimal amount){ OrdersBean.addOrders(uid,number,amount); }
//    public static void addOrder(ArrayList<Book> carts,int uid){
//        int orderId = OrderBean.getOrderId();
//        //移除bookId为空的记录
//        OrderBean.removeOrderByOrderId(orderId);
//        for(Book book : carts){
//            OrderBean.addOrder(orderId,book.getId());
//        }
//        //从购物车中移除所有已经结算的商品
//        cartBean.removeAll(uid);
//    }
//
//    public static ArrayList<singalOrder> getOrderByOrderId(int orderId){ return OrderBean.getOrderByOrderId(orderId); }
//
//    public static Orders getOrdersByOrderId(int orderId){ return OrdersBean.getOrdersByOrderId(orderId); }
//
//    public static void removeOrderBy(int orderId){
//        System.out.println(orderId);
//        OrderBean.removeOrderByOrderId(orderId);
//        OrdersBean.removeOrdersByOrderId(orderId);
//    }
//}
