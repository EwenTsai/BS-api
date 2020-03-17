package tk.ewentsai.contronller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.unit.HttpRequest;

@RestController
@CrossOrigin(allowCredentials = "true")//允许请求带上cookie
public class WXLoginController {
    @RequestMapping("/api/user/wxLogin")
    public Result wxLogin(String code){
        String codes = HttpRequest.sendGet("https://open.weixin.qq.com/connect/oauth2/authorize","appid=wxaf2296592f00e75c&"+
                "a");
        System.out.println("code值=" + code + "," + "当前类=WXLoginController.wxLogin()");
        /**
         * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
         * GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
         * appid，secret 微信小程序 账户设置中存在 不能传递到前端
         *
         */
        String result = HttpRequest.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token","appid=wxaf2296592f00e75c&" +
                "secret=5efdbb85521eed60f1a606d14b1b90f9&" +
                "code=" + code + "&"+
                "grant_type=authorization_code");
        System.out.println("result值=" + result + "," + "当前类=WXLoginController.wxLogin()");

        return null;
    }
}
