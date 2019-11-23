package tk.ewentsai.contronller;

import org.springframework.web.bind.annotation.RequestMapping;
import tk.ewentsai.pojo.User;
import tk.ewentsai.serves.CartService;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.unit.vaildateCode;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public UserController(UserService userService, CartService cartService){
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping("/api/user")
    public User findOneUser(String uname){
        System.out.println("here");
        return userService.findUserByUname(uname);
    }
    //登陆
    @RequestMapping(value = "/api/user/login",produces = {"application/json;charset=UTF-8"})
    public String login(String uname, String pwd, String VaildateCode, HttpSession hs, HttpServletResponse response){
        String returnString;
        //检查验证码
        if(vaildateCode.checkCode((String) hs.getAttribute("vaildateCode"),VaildateCode )){
            User user = userService.findUserByUname(uname);
            if (user != null) {
                //检查密码是否正确
                if(user.getPwd().equals(pwd)){
                    //将user的信息存入session
                    hs.setAttribute("user", user);
                    //登陆成功后添加cookies
                    Cookie cookie = new Cookie("uid", user.getUid()+"");
                    //设置cookies存活时间
                    cookie.setMaxAge(3*24*3600);
                    //设置cookie的路径，cookie的访问有路径限制
                    cookie.setPath("/BTS");
                    response.addCookie(cookie);
                    //将用户购物车的信息放入session中
                    hs.setAttribute("Carts", cartService.findCartByUid(user.getUid()));
                    returnString = "isLoginSuccess";
                }else{
                    returnString = "密码错误";
                }
            }else {
                returnString = "用户名或密码错误";
            }
        }else{
            returnString = "验证码错误";
        }
        return returnString;
    }
    //注册
    @RequestMapping(value = "/api/user/register",produces = {"application/json;charset=UTF-8"})
    public String register(String uname, String pwd, String VaildateCode, HttpSession hs) {
        String returnString;
        //再次检查验证码
        if(vaildateCode.checkCode((String) hs.getAttribute("vaildateCode"),VaildateCode)){
            //检查用户名是否已存在
//            User user = manageUser.checkUname(uname,pwd);
            User user = userService.findUserByUname(uname);
            if(user==null){
                //不存在同名的用户名，进行注册
                userService.addUser(uname,pwd);
                returnString = "isRegisterSuccess";
            }else{
                //存在同名的用户名
                returnString = "此用户名已经被注册";
            }
        }else{
            returnString = "验证码错误";
        }
        return returnString;
    }
    //使用cookie实现免登录
    @RequestMapping("/api/user/check")
    public User check(int uid,HttpSession hs) {
        User user = userService.findUserByUid(uid);
        if(user!=null){
            //将user的信息放入session中
            hs.setAttribute("user", user);
            //将用户购物车的信息放入session中
            hs.setAttribute("Carts", cartService.findCartByUid(user.getUid()));
        }
        return user;
    }
}
