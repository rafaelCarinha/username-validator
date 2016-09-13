package com.intertec.uservalidator;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intertec.uservalidator.service.ForbiddenWordsService;
import com.intertec.uservalidator.service.UserService;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
	
	
	@Autowired
	private UserService 		  scriptService;
	
	@Autowired
	private ForbiddenWordsService forbiddenWordService;
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameHasLessThen6Characteres() {
		
		forbiddenWordService.readAndSaveForbiddenWordsFromFile();
		
		scriptService.saveUser("abc");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameIsNull() {
		
		forbiddenWordService.readAndSaveForbiddenWordsFromFile();
		
		scriptService.saveUser(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIfUsernameIsEmpty() {
		
		forbiddenWordService.readAndSaveForbiddenWordsFromFile();
		
		scriptService.saveUser("");
	}
	
	@Test
	public void testSuccessCase() {
		forbiddenWordService.readAndSaveForbiddenWordsFromFile();
		
		Map<Boolean, List<String>> result = scriptService.saveUser("rafael");
		
		assertTrue(result.containsKey(true));
		
	}
	
	@Test
	public void testIfUsernameIsAlreadySaved() {
		
		forbiddenWordService.readAndSaveForbiddenWordsFromFile();
		
		scriptService.saveUser("intertec");
		
		Map<Boolean, List<String>> result = scriptService.saveUser("intertec");
		
		assertTrue(result.containsKey(false) && result.get(false) != null);
		
	}
	
	@Test
	public void testIfUsernameIsForbidden() {
		
		forbiddenWordService.readAndSaveForbiddenWordsFromFile();
		
		Map<Boolean, List<String>> forbiddenResult = scriptService.saveUser("cannabis");
		
		assertTrue(forbiddenResult.containsKey(false) && forbiddenResult.get(false) != null);
		
	}
	
}
