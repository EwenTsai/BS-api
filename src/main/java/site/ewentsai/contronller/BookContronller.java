package site.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.ewentsai.model.entity.Book;
import site.ewentsai.serves.BookService;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class BookContronller {
    @Autowired
    private BookService bookService;

    @Autowired
    private RedisTemplate redisTemplate;

    //根据搜索的关键词进行搜索
    @RequestMapping("/api/Book/search")
    public Page<Book> search(String searchText) { return bookService.search(searchText); }

    //根据id进行搜索
    @RequestMapping("/api/Book/searchBook")
    public Book search(int id) { return bookService.search(id); }

    //返回所有书本
    @RequestMapping("/api/Book/all")
    public List<Book> all(){return bookService.findAll();};
    //分页显示
    @RequestMapping("/api/Book")
    public Page<Book> pagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int num){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        System.out.println(valueOperations.get("rootroot"));
        return bookService.findAll(page,num); }

    //按书本销量排序
    @RequestMapping("/api/Book/sales")
    public Page<Book> sales(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int num){ return bookService.orderBySales(page,num); }

    //空库存查询
    @RequestMapping("/api/Book/stock")
    public Page<Book> stock(@RequestParam(defaultValue = "0") int pageNum){ return bookService.findByStockLessThanEqual(pageNum); }
}
