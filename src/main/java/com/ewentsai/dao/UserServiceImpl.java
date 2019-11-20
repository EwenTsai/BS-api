package com.ewentsai.dao;


import com.ewentsai.pojo.User;
import org.apache.ibatis.annotations.Param;

public class UserServiceImpl {
	private UserMapper UserMapper;

	public UserMapper getUserMapper() { return UserMapper; }
	public void setUserMapper(UserMapper userMapper) { UserMapper = userMapper; }


	public User FindByUname(String uname) { return UserMapper.getUserByUname(uname); }

	public User FindById(String id) { return UserMapper.getUserById(id); }

	public void AddUser(@Param("uname")String uname, @Param("pwd")String pwd) {  UserMapper.insertUser(uname,pwd); }

	public void changeUser(String uid, String imageAdress) { UserMapper.updateUserById(uid,imageAdress); }
}
