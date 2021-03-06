package site.ewentsai.contronller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.ewentsai.common.Result.Result;
import site.ewentsai.model.entity.Orders;
import site.ewentsai.model.entity.User;
import site.ewentsai.serves.OrdersService;
import site.ewentsai.common.Result.ResultFactory;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class OrdersContronller {

    @Autowired
    private OrdersService ordersService;

    //订单详情信息获取
    @RequestMapping("/api/Order/get")
    public Result orderDetail(String orderId){ return ResultFactory.buildSuccessResult(ordersService.getOrderDetail(orderId)); }

    //订单删除
    @RequestMapping("/api/Order/remove")
    public void removeOrder(String orderId){
        ordersService.remove(orderId);
    }

    //通过用户的uid来获取订单信息
    //分页显示
    @RequestMapping("/api/Order")
    public Page<Orders> orders(@RequestParam(defaultValue = "0") int pageNum){

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");

        return ordersService.getOrders(user.getUid(), pageNum);
    }
}
