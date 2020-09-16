package com.flyflyyun.tongtech.test;

//业务层实现
public class UserServiceImpl{

	public void login() {
		System.out.println("UserServiceImpl-service层被调用了。。。");
		//实例化dao层
		//传统方式，自己new对象
		IUserDao userDao = new UserDaoImpl();
		userDao.findByUsernameAndPassword();
	}
}