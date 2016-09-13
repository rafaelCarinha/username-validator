package com.intertec.uservalidator.service;

import java.util.List;

public interface ForbiddenWordsService {
	
	List<String> readAndSaveForbiddenWordsFromFile();

}
