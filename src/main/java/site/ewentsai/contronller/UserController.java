package site.ewentsai.contronller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import site.ewentsai.common.Result.Result;
import site.ewentsai.model.entity.User;
import site.ewentsai.model.vo.UserVo;
import site.ewentsai.model.vo.loginInfoVo;
import site.ewentsai.model.vo.updateUserVo;
import site.ewentsai.serves.UserService;
import site.ewentsai.common.Result.ResultFactory;
import site.ewentsai.model.vo.registerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Result login(@Valid @RequestBody loginInfoVo loginInfoVo){
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
    public Result register(@Valid @RequestBody registerInfoVo registerInfoVo) {
//      处理注册信息错误
        String result = userService.register(registerInfoVo);
        if(result!=null) {
            return ResultFactory.buildFailResult(result);
        }else{
            return ResultFactory.buildSuccessResult("注册成功。");
        }
    }

    @RequestMapping("/api/user/check")
    public Result check() {

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return ResultFactory.buildSuccessResult(userVo);
    }
    //获取用户信息
    @RequestMapping("/api/user/get")
    public Result get(){

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return ResultFactory.buildSuccessResult(userVo);
    }
    //修改用户信息
    @RequestMapping("/api/user/update")
    public Result update(updateUserVo updateUserVo) throws ParseException {

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");

        //时间格式转换
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dft.parse(updateUserVo.getBirthday());
        userService.update(updateUserVo.getUname(),user.getPwd(),updateUserVo.getSex(), birthday);
        return ResultFactory.buildSuccessResult("修改成功");
    }
}
