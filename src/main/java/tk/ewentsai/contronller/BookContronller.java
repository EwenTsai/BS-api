package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class BookContronller {

    private final BookService bookService;

    @Autowired
    public BookContronller(BookService bookService) { this.bookService = bookService; }

    //根据搜索的关键词进行搜索
    @RequestMapping("/api/Book/search")
    public List<Book> search(String searchText) { return bookService.findBookByBookName(searchText); }

    //根据id进行搜索
    @RequestMapping("/api/Book/searchBook")
    public Book search(int id) {
        return bookService.findBookById(id);
    }
}