package com.intertec.uservalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.intertec.uservalidator.service.ForbiddenWordsService;

@SpringBootApplication(scanBasePackages = {"com.intertec.uservalidator.controller",
		"com.intertec.uservalidator.service","com.intertec.uservalidator.repository"})
public class App extends SpringBootServletInitializer{
    
    public static void main( String[] args ){
    	
    	ConfigurableApplicationContext context = SpringApplication.run(App.class);
    	
    	//Reads from file, and saves on Embedded Database the Forbidden Words List
    	context.getBean(ForbiddenWordsService.class).readAndSaveForbiddenWordsFromFile();
    }
}
