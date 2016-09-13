package com.intertec.uservalidator.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertec.uservalidator.model.ForbiddenWord;
import com.intertec.uservalidator.repository.ForbiddenWordRepository;
import com.intertec.uservalidator.service.ForbiddenWordsService;

@Service
public class ForbiddenWordServiceImpl implements ForbiddenWordsService {
	
	
	@Autowired
	private ForbiddenWordRepository forbiddenWordsRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(ForbiddenWordServiceImpl.class);
	
	private static final String FILENAME = "forbiddenWords.txt";
	
	
	@Override
	public List<String> readAndSaveForbiddenWordsFromFile() {

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {

			stream.forEach(word->{
				System.out.println(word);
				LOG.info("Saving forbidden word: "+word);
				forbiddenWordsRepository.save(new ForbiddenWord(word));
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
