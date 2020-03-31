package tk.ewentsai.contronller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
import tk.ewentsai.model.entity.User;
import tk.ewentsai.model.vo.UserVo;
import tk.ewentsai.model.vo.loginInfoVo;
import tk.ewentsai.model.vo.registerInfoVo;
import tk.ewentsai.model.vo.updateUserVo;
import tk.ewentsai.serves.CartService;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class UserController {
    @Autowired
    private UserService userService;

    //登陆
    @RequestMapping(value = "/api/user/login",produces = {"application/json;charset=UTF-8"})
    public Result login(@Valid @RequestBody loginInfoVo loginInfoVo,
                        HttpSession hs,
                        HttpServletResponse response){
        //检查验证码
        if(!hs.getAttribute("kaptchaCode").equals(loginInfoVo.getKaptchaCode().toLowerCase())){
            return ResultFactory.buildFailResult("验证码错误");
        }
        //检查用户名和密码是否正确
        UsernamePasswordToken token = new UsernamePasswordToken(loginInfoVo.getUname(),loginInfoVo.getPwd());
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException uae) {
            return ResultFactory.buildFailResult("用户名错误");
        }

        User user = userService.findUserByUsername(loginInfoVo.getUname());
        subject.getSession().setAttribute("user", user);
        return ResultFactory.buildSuccessResult("登陆成功");

    }
    //注册
    @RequestMapping(value = "/api/user/register",produces = {"application/json;charset=UTF-8"})
    public Result register(@Valid @RequestBody registerInfoVo registerInfoVo, HttpSession hs) {
        //检查验证码
        if(!hs.getAttribute("kaptchaCode").equals(registerInfoVo.getKaptchaCode().toLowerCase())){
            return ResultFactory.buildFailResult("验证码错误");
        }
//      处理注册信息错误
        String result = userService.register(registerInfoVo);
        if(result!=null) {
            return ResultFactory.buildFailResult(result);
        }else{
            return ResultFactory.buildSuccessResult("注册成功。");
        }
    }
    //使用cookie实现免登录
//    @RequestMapping("/api/user/check")
//    public Result check(String uid) {
//        User user = userService.check(uid);
//        boolean isAdmin = false;
//        //无此uid用户
//        if(user==null){
//            return ResultFactory.buildFailResult("无此用户");
//        }
//
//        UserVo userVo = new UserVo();
//        BeanUtils.copyProperties(user,userVo);
//        return ResultFactory.buildSuccessResult(userVo);
//    }
    //获取用户信息
    @RequestMapping("/api/user/get")
    public Result get(String uid){
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userService.check(uid),userVo);
        return ResultFactory.buildSuccessResult(userVo);
    }
    //修改用户信息
    @RequestMapping("/api/user/update")
    public Result update(updateUserVo updateUserVo) throws ParseException {
        User user = userService.check(updateUserVo.getUid());
        //时间格式转换
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dft.parse(updateUserVo.getBirthday());
        userService.update(updateUserVo.getUname(),user.getPwd(),updateUserVo.getSex(), birthday);
        return ResultFactory.buildSuccessResult("修改成功");
    }
}
