package com.intertec.uservalidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intertec.uservalidator.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
	
	
	@Autowired
	private UserService scriptService;
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameHasLessThen6Characteres() {
		scriptService.saveUser("abc");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameIsForbidden() {
		scriptService.saveUser("cannabis");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameIsNull() {
		scriptService.saveUser(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameIsEmpty() {
		scriptService.saveUser("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSuccessCase() {
		scriptService.saveUser("rafael");
	}

}
