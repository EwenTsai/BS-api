package tk.ewentsai.contronller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.model.pojo.Book;
import tk.ewentsai.serves.BookService;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class BookContronller {
    @Autowired
    private BookService bookService;

    //根据搜索的关键词进行搜索
    @RequestMapping("/api/Book/search")
    public List<Book> search(String searchText) { return bookService.findBookByBookName(searchText); }

    //根据id进行搜索
    @RequestMapping("/api/Book/searchBook")
    public Book search(int id) {
        return bookService.findBookById(id);
    }

    //分页显示
    @RequestMapping("api/Book")
    public PageInfo<Book> pagination(@RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        PageInfo<Book> pageInfo = new PageInfo<>(bookService.findBookByStock());
        return pageInfo;
    }
}
