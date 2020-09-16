package com.flyflyyun.tongtech.test;

import org.junit.Test;

public class SpringTest {
	//测试
	@Test
	public void test(){
		//创建service的示例
		UserServiceImpl userService = new UserServiceImpl();
		userService.login();
	}

	@Test
	public void test2(){
		//创建service的示例
		Factory factory = new Factory();
		IUserDao userDao = factory.getUserDAO();
		userDao.findByUsernameAndPassword();
	}

}