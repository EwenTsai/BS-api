package tk.ewentsai.serves.impl;

import org.springframework.beans.BeanUtils;
import tk.ewentsai.model.dao.UserRepository;
import tk.ewentsai.model.entity.User;
import tk.ewentsai.model.vo.registerInfoVo;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String uname,String password) {
        return userRepository.findUserByUnameAndPwd(uname,password);
    }

    @Override
    public User check(int uid) { return userRepository.findUserByUid(uid); }

    @Override
    public String register(registerInfoVo registerInfoVo) {
        //检验两次密码是否一致
        if(!registerInfoVo.getPwd().equals(registerInfoVo.getRePwd())){
            return "两次密码不一致";
        }
        //检查用户名长度
        if(registerInfoVo.getUname().length()<6 || registerInfoVo.getUname().length()>15){
            return "用户名格式错误";
        }
        //检查密码长度
        if(registerInfoVo.getPwd().length()<6 || registerInfoVo.getPwd().length()>25){
            return "密码格式错误";
        }
        //检查用户名是否已存在
        if(userRepository.findUserByUname(registerInfoVo.getUname())!=null){
            return "此用户名已经被注册";
        }else{
            User user = new User();
            BeanUtils.copyProperties(registerInfoVo,user);

            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd");
            Date date = new Date();// 获取当前时间
            user.setBirthday(sdf.format(date));

            user.setAge("0");
            user.setSex("1");
            user.setImageAdress("images/0.jpg");
            user.setRole("user");
            user.setState(1);

            userRepository.save(user);
            return null;
        }
    }

    @Override
    public void update(String uname, String pwd, String sex, Date birthday) {
        User user = userRepository.findUserByUname(uname);
        user.setSex(sex);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(formatter.format(birthday));
        userRepository.save(user);
    }
}
