package tk.ewentsai.manage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.ewentsai.pojo.Book;
import tk.ewentsai.pojo.Cart;

import java.util.ArrayList;

public class manageCart {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	private static CartServiceImpl cartBean = applicationContext.getBean("cartService",CartServiceImpl.class);

	public static int total = 0;

	public static ArrayList<Book> manage(ArrayList<Book> cartBooks , int id,int uid){

		if(cartBooks==null){
			cartBooks = new ArrayList<Book>();
		}
		//id大于0添加到购物车
		if(id>0){
			Book book = manageBook.searchID(id);
			cartBooks.add(book);
			//如果在购物车中该书的数量为0则插入数据不等于0则增加amount
			ArrayList<Cart> carts = cartBean.FindCartByUid(uid);
			boolean isNULL = true;
			for (Cart cart : carts){
				cart.getBookId();
				if(cart.getBookId()==id){
					cartBean.changeAmountByBookId(cart.getId(),cart.getAmount()+1);
					isNULL = false;
					break;
				}
			}
			if(isNULL){
				cartBean.addCart(uid,book.getId(),1);
			}
			total+=book.getPrice();
			//id小于0从购物车里删除
		}else if(id<0){
			//将id值变为正数
			id=-id;
			for (Book book : cartBooks) {
				if(book.getId()==id){
					//判断amount是否为0
					//为0则删除对应数据库记录
					int amount = cartBean.FindCartByBookIdAndUid(id,uid).getAmount();
					if(amount==1){
						cartBean.removeByBookId(id);
					}else{
						cartBean.changeAmountByBookId(id,amount-1);
					}
					cartBooks.remove(book);
					total-=book.getPrice();
					break;
				}
			}
		}
		return cartBooks;
	}

	public static ArrayList<Book> getCartByUid(int uid){
		ArrayList<Cart> cart = cartBean.FindCartByUid(uid);
		ArrayList<Book> carts = new ArrayList<>();
		for(Cart c : cart){
			for(int j=0; j<c.getAmount(); j++){
				carts.add(manageBook.searchID(c.getBookId()));
			}
		}
		return carts;
	}
	public static int getTotal() { return total; }
}
