package tk.ewentsai.contronller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.pojo.Book;
import tk.ewentsai.pojo.Cart;
import tk.ewentsai.pojo.User;
import tk.ewentsai.serves.BookService;
import tk.ewentsai.serves.CartService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartContronller {

    private final CartService cartService;
    private final BookService bookService;

    public CartContronller(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    //购物车信息修改
	//存在线程安全安全问题
    @RequestMapping("/api/Cart/updateCart")
    public List<Book> cart(HttpSession hs, @RequestParam(defaultValue = "0") int bookId) {
        ArrayList<Cart> Carts = (ArrayList<Cart>) hs.getAttribute("Carts");
        //获取当前操作购物车的用户
        User user = (User)hs.getAttribute("user");
        //用户购物车为空的时，为其创建一个空的arrayList
        if(Carts==null){
            Carts = new ArrayList<Cart>();
		}
		//id大于0添加到购物车
		if(bookId>0){
			//如果在购物车中该书的数量为0则插入数据不等于0则增加amount
			Cart cart = cartService.findCartByBookIdAndUid(bookId,user.getUid());
			if(cart==null){
				cartService.addCart(user.getUid(), bookId,1);
			}else{
				cartService.updateAmountByBookIdAndUid(cart.getUid(), bookId,cart.getAmount()+1);
			}
		// id小于0从购物车里删除
		}else if(bookId<0){
			//将id值变为正数
			bookId=-bookId;
			//判断amount是否为0
			//为0则删除对应数据库记录
			int amount = cartService.findCartByBookIdAndUid(bookId,user.getUid()).getAmount();
			if(amount==1){
				cartService.removeCartByBookIdAndUid(user.getUid(), bookId);
			}else{
				cartService.updateAmountByBookIdAndUid(user.getUid(),bookId,amount-1);
			}
			Cart cart = cartService.findCartByBookIdAndUid(bookId,user.getUid());
			Carts.remove(cart);
		}
        hs.setAttribute("Carts",Carts);

		//将cart对象转化为Book传到前端显示
		ArrayList<Book> cartBook = new ArrayList<>();
		for(Cart cart : Carts){
			for(int i = 0; i<cart.getAmount(); i++){
				cartBook.add(bookService.findBookById(cart.getBookId()));
			}
		}
        return cartBook;
    }
}
