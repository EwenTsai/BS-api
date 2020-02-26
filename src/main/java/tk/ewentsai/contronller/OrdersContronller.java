package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.model.entity.*;
import tk.ewentsai.serves.OrdersService;
import tk.ewentsai.serves.singalOrderService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class OrdersContronller {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private singalOrderService singalOrderService;

    //订单详情信息获取
    @RequestMapping("/api/Order/get")
    public ArrayList orderDetail(int orderId){
        List<singalOrder> singalOrder = singalOrderService.findOrderByOrderId(orderId);
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
    public Page<Orders> orders(@RequestParam(defaultValue = "0") int pageNum, HttpSession hs){
        int uid = ((User)hs.getAttribute("user")).getUid();
        return ordersService.getOrders(uid, pageNum);
    }
}
