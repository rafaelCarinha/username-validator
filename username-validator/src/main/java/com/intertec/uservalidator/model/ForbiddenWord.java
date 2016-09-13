package com.intertec.uservalidator.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public @Data class ForbiddenWord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3127742302343756622L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idWord")
	@JsonProperty("id")
    private long idWord;
    
	@JsonProperty("word")
	@Column(name = "word")
    private String word;
	
	public ForbiddenWord(){
	}
	
	public ForbiddenWord(String word){
		this.word = word;
	}
    
}
