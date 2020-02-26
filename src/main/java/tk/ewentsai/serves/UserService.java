package tk.ewentsai.serves;

import tk.ewentsai.model.entity.User;
import tk.ewentsai.model.vo.registerInfoVo;

import java.util.Date;

public interface UserService {
    User login(String uname,String pwd);
    String register(registerInfoVo registerInfoVo);
    void update(String uname, String pwd, String sex, Date birthday);
    User check(int uid);
}
