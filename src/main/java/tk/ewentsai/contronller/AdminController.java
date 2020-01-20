package tk.ewentsai.contronller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
import tk.ewentsai.model.pojo.Book;
import tk.ewentsai.serves.*;

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
    public Result updateBook(Book book){
        System.out.println("book.toString()值=" + book.toString() + "," + "当前类=AdminController.updateBook()");
        bookService.updateBook(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }
}
