package com.ankush.journalApp.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.ankush.journalApp.entity.User;
import com.ankush.journalApp.repository.UserRepository;

@SpringBootTest
public class UserDetailsServiceImplTests {
	
	@InjectMocks
	private UserDetailsServiceImpl userDetailsService;
	
	@Mock
	private UserRepository userRepository;
	
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void loadUserByUsernameTest() {
		when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("akash").password("akash123").roles(new ArrayList<>()).build());
		UserDetails user = userDetailsService.loadUserByUsername("akash");
		Assertions.assertNotNull(user);
	}

}
