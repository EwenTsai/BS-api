package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.pojo.Book;
import tk.ewentsai.pojo.PageBean;
import tk.ewentsai.serves.BookService;
import tk.ewentsai.serves.OrdersService;
import tk.ewentsai.serves.eBookService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class BookContronller {

    private final BookService bookService;
    private final eBookService eBookService;
    private final OrdersService ordersService;

    @Autowired
    public BookContronller(BookService bookService, tk.ewentsai.serves.eBookService eBookService, OrdersService ordersService) {
        this.bookService = bookService;
        this.eBookService = eBookService;
        this.ordersService = ordersService;
    }

    //根据搜索的关键词进行搜索
    @RequestMapping("/api/Book/search")
    public List<Book> search(String searchText) {
        return bookService.findBookByBookName(searchText);
    }
    //根据id进行搜索
    @RequestMapping("/api/Book/searchBook")
    public Book search(int id) {
        return bookService.findBookById(id);
    }
    //分页显示书本
    @RequestMapping("/api/Book/pagination")
    public List pagination(String paginationClass, @RequestParam(value = "isNextPage",defaultValue = "0") int isNextPage, HttpSession hs) {
        //当前页数默认为第一页
        int currPage = 1;
        //根据商品类型得到总页数，并记录在session中
        PageBean pageBean = new PageBean<>(bookService.findAllBook().size());
        hs.setAttribute("totalPage",pageBean.getTotalPage());
        hs.setAttribute("paginationClass",paginationClass);
        //根据isNextPage来判断上下页  1为下一页  0返回第一页  —1为下一页
        switch (isNextPage){
            case 1:
                currPage = (int) hs.getAttribute("currPage");
                currPage+=1;
                break;
            case 0:
                currPage = 1;
                break;
            case -1:
                currPage = (int) hs.getAttribute("currPage");
                currPage-=1;
                break;
        }
        //通过paginationClass来选择不同的列表
        switch (paginationClass){
            case "newBook":
//                pageBean.setList(BookBean.paginationBook((CurrPage-1)*10));
                pageBean.setList(bookService.paginationBook((currPage-1)*10));
                break;
            case "eBook":
                pageBean.setList(eBookService.paginationBook((currPage-1)*10));
                break;
            case "orders":
                pageBean.setList(ordersService.paginationOrders((currPage-1)*10));
        }
        hs.setAttribute("currPage",currPage);
        return pageBean.getList();
    }
}
