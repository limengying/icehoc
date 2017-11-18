package com.icehockey.test;


import org.junit.Test;

import com.icehockey.entity.User;
import com.icehockey.service.UserService;



public class UnitTest1 {

	@Test
	public void test() {
		UserService userService=new UserService();
		User user=userService.loginByTelepone("1", "1");
		System.out.println(user);
	}
	@Test
	public void test2() {
		UserService userService=new UserService();
		User user=userService.Register("100002", "100002");
		System.out.println(user);
	}
}
