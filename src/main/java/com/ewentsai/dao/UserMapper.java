package com.ewentsai.dao;

import com.ewentsai.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	@Select("select * from users where uname=#{uname}")
	User getUserByUname(String uname);

	@Select("select * from users where uid = #{uid}")
	User getUserById(String id);

	@Insert("insert into users (uid,uname,pwd,age,birthday,imageAdress) values (default,#{uname},#{pwd},0,now(),'images/0.jpg')")
	void insertUser(@Param("uname") String uname, @Param("pwd") String pwd);

	@Update("update users set imageAdress = #{imageAdress} where uid = #{uid}")
	void updateUserById(@Param("uid") String uid, @Param("imageAdress") String imageAdress);
}
