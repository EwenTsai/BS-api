package tk.ewentsai.contronller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.pojo.Cart;
import tk.ewentsai.pojo.Orders;
import tk.ewentsai.pojo.User;
import tk.ewentsai.pojo.singalOrder;
import tk.ewentsai.serves.CartService;
import tk.ewentsai.serves.OrdersService;
import tk.ewentsai.serves.singalOrderService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
@RestController
public class OrdersContronller {

    private final OrdersService ordersService;
    private final singalOrderService singalOrderService;
    private final CartService cartService;

    public OrdersContronller(OrdersService ordersService, tk.ewentsai.serves.singalOrderService singalOrderService, CartService cartService) {
        this.ordersService = ordersService;
        this.singalOrderService = singalOrderService;
        this.cartService = cartService;
    }

    //购物车结算
    @RequestMapping("/api/Order/settle")
    public void orders(BigDecimal amount, HttpSession hs){
        User user = (User)hs.getAttribute("user");
        ArrayList<Cart> Carts = (ArrayList<Cart>)hs.getAttribute("Carts");
        int number = 0;
        for(Cart cart : Carts){
            number+=cart.getAmount();
        }
        ordersService.addOrder(user.getUid(),number,amount);
        //通过空值来获得orderid
        int orderId = singalOrderService.findOrderId();
        singalOrderService.removeOrderByOrderId(orderId);

        for(Cart cart : Carts){
            for(int i=0; i<cart.getAmount(); i++){
                singalOrderService.addOrder(orderId,cart.getBookId());
            }
        }
        //结算成功移除购物车商品
        hs.setAttribute("Carts",new ArrayList<Cart>());
        cartService.removeAllByUid(user.getUid());
    }

    //订单详情信息获取
    @RequestMapping("/api/Order/get")
    public ArrayList orderDetail(int orderId){
        ArrayList<singalOrder> singalOrder = singalOrderService.findOrderByOrderId(orderId);
        Orders order = ordersService.findOrdersByOrderId(orderId);
        ArrayList result = new ArrayList();
        result.add(order);
        result.add(singalOrder);
        return result;
    }

    //订单删除
    @RequestMapping("/api/Order/remove")
    public void removeOrder(int orderId){
        singalOrderService.removeOrderByOrderId(orderId);
        ordersService.removeOrderById(orderId);
    }
}
