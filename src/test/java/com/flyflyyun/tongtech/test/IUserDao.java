package com.flyflyyun.tongtech.test;

//用户的dao层
public interface IUserDao {
	//向数据查询数据，根据用户名和密码
	void findByUsernameAndPassword();
}