package tk.ewentsai.contronller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
import tk.ewentsai.model.entity.Book;
import tk.ewentsai.model.entity.User;
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

	//得到购物车详情
	@RequestMapping("api/Cart")
	public Result get(HttpSession hs){
		User user = (User)hs.getAttribute("user");

		List<Object[]> carts = cartService.getCart(user.getUid());

		List<BookVo> result = new ArrayList<>();

		for(Object[] o : carts ){
			result.add(new BookVo(o));
		}
		return ResultFactory.buildSuccessResult(result);
	}

	//购物车添加
	@RequestMapping("/api/Cart/add")
	public Result add(HttpSession hs, int bookId){
		User user = (User)hs.getAttribute("user");
		Book book = bookService.search(bookId);
		if(book.getStock()==0){
			return ResultFactory.buildFailResult("库存为0");
		}else{
			cartService.add(user.getUid(),bookId);
			return ResultFactory.buildSuccessResult("添加成功");
		}
	}
	//购物车删除
	@RequestMapping("/api/Cart/delete")
	public Result delete(HttpSession hs, int bookId){
		User user = (User)hs.getAttribute("user");
		cartService.remove(user.getUid(), bookId);
		return ResultFactory.buildSuccessResult("删除成功");
	}
	//购物车结算
	@RequestMapping("/api/Cart/settle")
	public Result settle(BigDecimal amount, HttpSession hs){
		User user = (User)hs.getAttribute("user");
		cartService.settle(amount,user.getUid());
		return ResultFactory.buildSuccessResult("结算成功");
	}
}
