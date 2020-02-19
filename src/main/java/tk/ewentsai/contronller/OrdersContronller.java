package tk.ewentsai.contronller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.model.pojo.*;
import tk.ewentsai.serves.CartService;
import tk.ewentsai.serves.OrdersService;
import tk.ewentsai.serves.singalOrderService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class OrdersContronller {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private singalOrderService singalOrderService;
    @Autowired
    private CartService cartService;

    //订单详情信息获取
    @RequestMapping("/api/Order/get")
    public ArrayList orderDetail(int orderId){
        ArrayList<singalOrder> singalOrder = singalOrderService.findOrderByOrderId(orderId);
        Orders order = ordersService.getOrder(orderId);
        ArrayList result = new ArrayList(singalOrder);
        result.add(order);
        return result;
    }

    //订单删除
    @RequestMapping("/api/Order/remove")
    public void removeOrder(int orderId){
        singalOrderService.removeOrderByOrderId(orderId);
        ordersService.remove(orderId);
    }

    //通过用户的uid来获取订单信息
    //分页显示
    @RequestMapping("/api/Order")
    public PageInfo<Orders> orders(@RequestParam(defaultValue = "1") int pageNum, HttpSession hs){
        int uid = ((User)hs.getAttribute("user")).getUid();
        PageHelper.startPage(pageNum,10);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersService.getOrders(uid));
        return pageInfo;
    }
}
