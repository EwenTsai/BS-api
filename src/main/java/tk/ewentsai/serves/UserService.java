package tk.ewentsai.serves;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.pojo.User;

public interface UserService {
    User findUserByUname(String uname);
    User findUserByUid(int uid);
    void addUser(@Param("uname") String uname, @Param("pwd") String pwd);
}
