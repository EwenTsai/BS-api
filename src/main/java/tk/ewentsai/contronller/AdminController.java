package tk.ewentsai.contronller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
import tk.ewentsai.model.pojo.Book;
import tk.ewentsai.model.vo.updateBookVo;
import tk.ewentsai.serves.*;

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

    //分页显示--书籍
    @RequestMapping("/api/Admin/Book")
    public PageInfo<Book> pagination(@RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        PageInfo<Book> pageInfo = new PageInfo<>(bookService.findAllBook());
        return pageInfo;
    }
    //修改书本信息
    @RequestMapping("/api/Admin/updateBook")
    public Result updateBook(updateBookVo updateBookVo) throws ParseException {
        Book book = new Book();
        BeanUtils.copyProperties(updateBookVo,book);
        //string转化为date
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse(updateBookVo.getReleaseTime());
        book.setReleaseTime(date);
        bookService.updateBook(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }
}
