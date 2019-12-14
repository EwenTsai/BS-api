package tk.ewentsai.contronller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tk.ewentsai.Result.Result;
import tk.ewentsai.Result.ResultFactory;
import tk.ewentsai.pojo.User;
import tk.ewentsai.pojo.vo.loginInfoVo;
import tk.ewentsai.pojo.vo.registerInfoVo;
import tk.ewentsai.serves.CartService;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.ewentsai.unit.vaildateCode;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Enumeration;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class UserController {

    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public UserController(UserService userService, CartService cartService){
        this.userService = userService;
        this.cartService = cartService;
    }
    //登陆
    @RequestMapping(value = "/api/user/login",produces = {"application/json;charset=UTF-8"})
    public Result login(@Valid @RequestBody loginInfoVo loginInfoVo, HttpSession hs, HttpServletResponse response, BindingResult bindingResult){
        //检验输入信息为空的情况
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        //检查验证码
        if(!vaildateCode.checkCode((String) hs.getAttribute("vaildateCode"),loginInfoVo.getVaildateCode())){
            return ResultFactory.buildFailResult("验证码错误");
        }
        //检查用户名和密码是否正确
        User user = userService.findUserByUname(loginInfoVo.getUname());
        if(user==null || !user.getPwd().equals(loginInfoVo.getPwd())){
            return ResultFactory.buildFailResult("用户名或密码错误");
        }
        //将登陆信息写入浏览器端端cookie和服务器端端session
        hs.setAttribute("user", user);
        Cookie cookie = new Cookie("uid", user.getUid()+"");
        //设置cookies存活时间
        cookie.setMaxAge(3*24*3600);
        //设置cookie的路径，cookie的访问有路径限制
        cookie.setPath("/");
        response.addCookie(cookie);
        //将用户购物车的信息放入session中
        hs.setAttribute("Carts", cartService.findCartByUid(user.getUid()));
        return ResultFactory.buildSuccessResult("登陆成功。");
    }

    //注册
    @RequestMapping(value = "/api/user/register",produces = {"application/json;charset=UTF-8"})
    public Result register(@Valid @RequestBody registerInfoVo registerInfoVo, HttpSession hs, BindingResult bindingResult) {
        //检验输入信息为空的情况
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        //检查验证码
        if(!vaildateCode.checkCode((String) hs.getAttribute("vaildateCode"),registerInfoVo.getVaildateCode())){
            return ResultFactory.buildFailResult("验证码错误");
        }
        //检查用户名是否已存在
        User user = userService.findUserByUname(registerInfoVo.getUname());
        //存在同名的用户名
        if(user!=null) {
            return ResultFactory.buildFailResult("此用户名已经被注册");
        }
        //不存在同名的用户名，进行注册
        userService.addUser(registerInfoVo.getUname(),registerInfoVo.getPwd());
        return ResultFactory.buildSuccessResult("注册成功。");
    }
    //使用cookie实现免登录
    @RequestMapping("/api/user/check")
    public Result check(int uid,HttpSession hs) {
        User user = userService.findUserByUid(uid);
        //无此uid用户
        if(user==null){
            return ResultFactory.buildFailResult("无此用户");
        }
        //将user的信息放入session中
        hs.setAttribute("user", user);
        //将用户购物车的信息放入session中
        hs.setAttribute("Carts", cartService.findCartByUid(user.getUid()));
        return ResultFactory.buildSuccessResult(user);
    }
}
