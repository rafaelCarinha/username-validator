package com.intertec.uservalidator.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.StringUtils;

import com.intertec.uservalidator.model.ForbiddenWord;
import com.intertec.uservalidator.model.User;
import com.intertec.uservalidator.repository.ForbiddenWordRepository;
import com.intertec.uservalidator.repository.UserRepository;
import com.intertec.uservalidator.service.UserService;
import com.intertec.uservalidator.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ForbiddenWordRepository    forbiddenWordRepository;
	
	@Autowired
	private UserRepository 			   userRepository;
	
	private boolean forbiddenWord      = false;
	
	private List<String> possibleWords =  new ArrayList<>();
	
	private static final Logger LOG    = LoggerFactory.getLogger(UserServiceImpl.class);


	@Override
	public Map<Boolean, List<String>>  saveUser(String userName) {
		forbiddenWord = false;
		
		Map<Boolean, List<String>> result = new HashMap<>();
		
		
		//Check if word has at least 6 characters (Otherwise, throw Exception)
		if(StringUtil.isNullOrEmpty(userName)){
			LOG.error("Username cannot be null or empty!");
			throw new IllegalArgumentException("Username cannot be null or empty!");
		}
		//Check if word has at least 6 characters (Otherwise, throw Exception)
		else if(userName.length()<6){
			LOG.error("Username should have at least 6 characters!");
			throw new IllegalArgumentException("Username should have at least 6 characters!");
		}
		
		//Retrieve Forbidden Words List
		Iterable<ForbiddenWord> forbiddenWords =  forbiddenWordRepository.findAll();
		
		//If Word is forbidden, throw ForbiddenWordException
		forbiddenWords.forEach(word->{
			if(userName.equalsIgnoreCase(word.getWord())){
				forbiddenWord = true;
 				//Reverse word				
				StringBuilder str = new StringBuilder(userName);
				//Return Map with 14 words
				possibleWords = returnPossibleWords(str.reverse().toString());
				LOG.error("Forbidden Word for Username Found: "+userName);
			}
		});
		
		if(forbiddenWord){
			result.put(false, possibleWords);
			LOG.error("Returning possible words: "+result.toString());
			return result;
			
		}else{
			
			//Check if username is not saved yet
			User user = userRepository.findUserByName(userName);
			
			if(user!=null){
				//Return Map with 14 words
				possibleWords = returnPossibleWords(userName);
				result.put(false, possibleWords);
				LOG.error("Username already exists: "+userName);
				LOG.error("Returning possible words: "+result.toString());				
			}else{
				//If doesn´t exist, save username			
				userRepository.save(new User(userName));
				LOG.info("User saved successfully: "+userName);
				
				result.put(true, null);
				
			}
		}
		
		return result;
		
	}
	
	/**
	 * Returns a List<String> of possible words
	 * @param word
	 * @return
	 */
	private List<String> returnPossibleWords(String word){
		
		List<String> possibleWords = new ArrayList<String>();
		
		for(int i=0; i<14; i++){
			//Check if username is not saved yet
			User user = userRepository.findUserByName(word+""+i);
			if(user==null){
				possibleWords.add(word+""+i);
			}
		}
		
		return possibleWords;
		
	}
	
}
