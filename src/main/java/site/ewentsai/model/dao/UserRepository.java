package site.ewentsai.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.ewentsai.model.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUname(String uname);
    User findUserByUnameAndPwd(String uname, String pwd);
    User findUserByUid(String uid);
}
