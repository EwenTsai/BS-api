package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.model.entity.Book;
import tk.ewentsai.serves.BookService;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class BookContronller {
    @Autowired
    private BookService bookService;

    //根据搜索的关键词进行搜索
    @RequestMapping("/api/Book/search")
    public Page<Book> search(String searchText) {
        return bookService.findBookByBooknameIsLike(searchText);
    }

    //根据id进行搜索
    @RequestMapping("/api/Book/searchBook")
    public Book search(int id) { return bookService.findBookById(id); }

    //分页显示
    @RequestMapping("/api/Book")
    public Page<Book> pagination(@RequestParam(defaultValue = "0") int pageNum){ return bookService.findAll(pageNum); }

    //按书本销量排序
    @RequestMapping("/api/Book/sales")
    public Page<Book> sales(@RequestParam(defaultValue = "0") int pageNum){ return bookService.findAllOrderBySales(pageNum); }

    //空库存查询
    @RequestMapping("/api/Book/stock")
    public Page<Book> stock(@RequestParam(defaultValue = "0") int pageNum){ return bookService.findByStockLessThanEqual(pageNum); }
}
