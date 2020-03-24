package tk.ewentsai.contronller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
import tk.ewentsai.common.unit.HttpRequest;
import tk.ewentsai.model.entity.User;
import tk.ewentsai.serves.UserService;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class WXLoginController {

    @Autowired
    private UserService userService;

    private static final String appid = "wxaf2296592f00e75c";
    private static final String secret = "5efdbb85521eed60f1a606d14b1b90f9";

    @RequestMapping("/api/user/wxLogin")
    public Result wxLogin(String code, HttpSession hs){
        boolean isLogin = false;
        /**
         * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
         * GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
         * appid，secret 微信小程序 账户设置中存在 不能传递到前端
         *
         */
        String result = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session",
                "appid=" + appid + "&" +
                "secret=" + secret + "&" +
                "js_code=" + code + "&"+
                "grant_type=authorization_code");

        JSONObject jsonObject = JSONObject.fromObject(result);
        if(jsonObject.get("openid")!=null){
            isLogin = true;
        }
        //微信第一次登陆进行信息录入
        User user = userService.WXRegister((String) jsonObject.get("openid"));

        return ResultFactory.buildSuccessResult(jsonObject.get("openid"));
    }
}
