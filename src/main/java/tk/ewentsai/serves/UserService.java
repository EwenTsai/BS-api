package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import tk.ewentsai.model.pojo.User;

public interface UserService {
    User login(String uname,String pwd);
    String register(@Param("uname") String uname, @Param("pwd") String pwd);
    User check(int uid);
}
