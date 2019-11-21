package tk.ewentsai.dao;

import org.apache.ibatis.annotations.Param;
import tk.ewentsai.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */
    User findUserByName(String uname);
    /**
     * 通过uid查询用户信息
     */
    User findUserByUid(int uid);
    /**
     * 添加用户
     */
    void addUser(@Param("uname") String uname, @Param("pwd") String pwd);
}
