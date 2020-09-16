package com.flyflyyun.tongtech.test;

//dao的实现类
public class UserDaoImpl implements IUserDao {
	@Override
	public void findByUsernameAndPassword() {
		System.out.println("UserDaoImpl-dao层被调用了");
	}
}