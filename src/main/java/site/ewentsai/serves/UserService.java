package site.ewentsai.serves;

import site.ewentsai.model.entity.User;
import site.ewentsai.model.vo.registerInfoVo;

import java.util.Date;

public interface UserService {
    User login(String uname,String pwd);
    String register(registerInfoVo registerInfoVo);
    User WXRegister(String openid);
    void update(String uname, String pwd, String sex, Date birthday);
    User findUserByUsername(String username);
}
