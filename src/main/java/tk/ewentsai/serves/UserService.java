package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.model.entity.User;
import tk.ewentsai.model.vo.registerInfoVo;

import java.util.Date;

public interface UserService {
    User login(String uname,String pwd);
    String register(registerInfoVo registerInfoVo);
    void update(@Param("uname") String uname, @Param("pwd") String pwd, @Param("sex") String sex, @Param("birthday") Date birthday);
    User check(int uid);
}
