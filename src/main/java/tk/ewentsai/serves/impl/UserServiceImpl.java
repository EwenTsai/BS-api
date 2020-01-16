package tk.ewentsai.serves.impl;

import tk.ewentsai.common.Result.Result;
import tk.ewentsai.common.Result.ResultFactory;
import tk.ewentsai.model.dao.UserDao;
import tk.ewentsai.model.pojo.User;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String uname,String password) { return userDao.findUserByNameAndPwd(uname,password); }

    @Override
    public User check(int uid) {
        return userDao.findUserByUid(uid);
    }

    @Override
    public String register(String uname, String pwd) {
        //检查用户名长度
        if(uname.length()<6 || uname.length()>15){
            return "用户名格式错误";
        }
        //检查密码长度
        if(pwd.length()<6 || pwd.length()>25){
            return "密码格式错误";
        }
        //检查用户名是否已存在
        if(userDao.findUserByName(uname)==null){
            return "此用户名已经被注册";
        }else{
            userDao.addUser(uname,pwd);
            return null;
        }
    }

    @Override
    public void update(String uname, String pwd, String sex, Date birthday) { userDao.updateUser(uname,pwd,sex,birthday); }
}
