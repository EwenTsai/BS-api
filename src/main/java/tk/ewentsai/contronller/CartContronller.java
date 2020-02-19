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
import tk.ewentsai.model.pojo.Cart;
import tk.ewentsai.model.pojo.User;
import tk.ewentsai.model.vo.BookVo;
import tk.ewentsai.serves.BookService;
import tk.ewentsai.serves.CartService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class CartContronller {
	@Autowired
    private CartService cartService;
	@Autowired
    private BookService bookService;

	//购物车添加
	@RequestMapping("/api/Cart/add")
	public Result add(HttpSession hs, int bookId){
		User user = (User)hs.getAttribute("user");
		Book book = bookService.findBookById(bookId);
		if(book.getStock()==0){
			return ResultFactory.buildFailResult("库存为0");
		}
		cartService.add(user.getUid(),bookId);
		return ResultFactory.buildSuccessResult("添加成功");
	}
	//购物车删除
	@RequestMapping("/api/Cart/delete")
	public Result delete(HttpSession hs, int bookId){
		User user = (User)hs.getAttribute("user");
		cartService.remove(user.getUid(),bookId);
		return ResultFactory.buildSuccessResult("删除成功");
	}
	//购物车结算
	@RequestMapping("/api/Cart/settle")
	public Result settle(BigDecimal amount, HttpSession hs){
		User user = (User)hs.getAttribute("user");
		cartService.settle(amount,user.getUid());
		return ResultFactory.buildSuccessResult("结算成功");
	}
	//分页显示
    @RequestMapping("api/Cart")
	public Result pagination(HttpSession hs){
		User user = (User)hs.getAttribute("user");
		ArrayList<Cart> carts = cartService.getCart(user.getUid());
		ArrayList<BookVo> result = new ArrayList<>();
		for(Cart cart : carts){
			Book book = bookService.findBookById(cart.getBookId());
			BookVo bookVo = new BookVo();
			BeanUtils.copyProperties(book,bookVo);
			result.add(bookVo);
		}
		return ResultFactory.buildSuccessResult(result);
	}
}
