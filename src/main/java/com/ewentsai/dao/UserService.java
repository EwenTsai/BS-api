package com.ewentsai.dao;

import com.ewentsai.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
	User FindByUname(String uname);
	User FindById(String id);
	void AddUser(@Param("uname") String uname, @Param("pwd") String pwd);
	void changeUser(@Param("uid") String uid, @Param("imageAdress") String imageAdress);
}
