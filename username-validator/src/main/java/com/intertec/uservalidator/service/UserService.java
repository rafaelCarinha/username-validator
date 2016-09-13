package com.intertec.uservalidator.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	
	Map<Boolean, List<String>> saveUser(String userName);

}
