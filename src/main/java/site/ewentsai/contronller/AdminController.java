package site.ewentsai.contronller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ewentsai.common.Result.Result;
import site.ewentsai.serves.*;
import site.ewentsai.common.Result.ResultFactory;
import site.ewentsai.model.entity.Book;
import site.ewentsai.model.vo.updateBookVo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookies
public class AdminController {

    @Autowired
    private BookService bookService;
    @Autowired
    private eBookService eBookService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private singalOrderService singalOrderService;

    //修改书本信息
    @RequiresRoles({"admin"})
    @RequestMapping("/api/Admin/updateBook")
    public Result updateBook(updateBookVo updateBookVo) throws ParseException {
        Book book = new Book();
        BeanUtils.copyProperties(updateBookVo,book);
        //string转化为date
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse(updateBookVo.getReleaseTime());
        book.setReleaseTime(date);
        bookService.update(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }
}
