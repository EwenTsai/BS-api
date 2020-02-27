package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
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

    //订单详情信息获取
    @RequestMapping("/api/Order/get")
    public Result orderDetail(int orderId){ return ResultFactory.buildSuccessResult(ordersService.getOrderDetail(orderId)); }

    //订单删除
    @RequestMapping("/api/Order/remove")
    public void removeOrder(int orderId){
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
