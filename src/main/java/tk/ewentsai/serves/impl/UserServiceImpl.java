package tk.ewentsai.serves.impl;

import tk.ewentsai.dao.UserDao;
import tk.ewentsai.pojo.User;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUname(String uname) {
        return userDao.findUserByName(uname);
    }

    @Override
    public User findUserByUid(int uid) {
        return userDao.findUserByUid(uid);
    }

    @Override
    public void addUser(String uname, String pwd) {
        userDao.addUser(uname,pwd);
    }
}
