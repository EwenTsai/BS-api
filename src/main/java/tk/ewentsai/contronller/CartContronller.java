package tk.ewentsai.contronller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import tk.ewentsai.serves.UserService;

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
	public Result get(){

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute("user");

		List<Object[]> carts = cartService.getCart(user.getUid());

		List<BookVo> result = new ArrayList<>();

		for(Object[] o : carts ){
			Book book = bookService.search((int)o[0]);
			result.add(new BookVo(o, book.getImageAdress()));
		}
		return ResultFactory.buildSuccessResult(result);
	}

	//购物车添加
	@RequestMapping("/api/Cart/add")
	public Result add(int bookId){

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute("user");

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
	public Result delete(int bookId){

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute("user");

		cartService.remove(user.getUid(), bookId);
		return ResultFactory.buildSuccessResult("删除成功");
	}
	//购物车结算
	@RequestMapping("/api/Cart/settle")
	public Result settle(BigDecimal amount){

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute("user");

		cartService.settle(amount,user.getUid());
		return ResultFactory.buildSuccessResult("结算成功");
	}
}
