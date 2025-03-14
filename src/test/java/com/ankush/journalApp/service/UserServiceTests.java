package com.ankush.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ankush.journalApp.entity.User;
import com.ankush.journalApp.repository.UserRepository;

//@SpringBootTest
//public class UserServiceTests {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private  UserService userService;
//	
//	@ParameterizedTest
//	@ArgumentsSource(UserArgumentsProvider.class)
//	public void testSaveNewUser(User user)
//	{
//		assertTrue(userService.saveNewUser(user));
//	}
//	
//	@Disabled
//	@ParameterizedTest
//	@CsvSource({
//		"1,1,2",
//		"2,3,6",
//		"6,2,8"
//		
//	})
//	public void tests(int a, int b, int expected)
//	{
//		assertEquals(expected, a+b);
//	}
//
//}
