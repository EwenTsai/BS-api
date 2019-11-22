//package tk.ewentsai.manage;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import tk.ewentsai.pojo.User;
//import tk.ewentsai.serves.impl.UserServiceImpl;
//
//public class manageUser {
//	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//	private static UserServiceImpl bean = applicationContext.getBean("userService",UserServiceImpl.class);
//
//	public static User checkUname(String uname, String password) {
//
//		User user = bean.FindByUname(uname);
//
//		if(user!=null&&password.equals(user.getPwd())){ }
//		else{
//			user = null;
//		}
//		return user;
//	}
//
//	public static User checkUid(String uid) { return bean.FindById(uid); }
//
//	public static boolean register(String uname,String pwd){
//		bean.AddUser(uname,pwd);
//		return true;
//	}
//	//根据uid更改imageAdress数据
//	public static void change(String uid,String imageAdress){ bean.changeUser(uid,imageAdress); }
//}
