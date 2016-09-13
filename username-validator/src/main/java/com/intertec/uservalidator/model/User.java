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
public @Data class User implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4760435927696334512L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idClient")
	@JsonProperty("id")
    private long idClient;
    
	@JsonProperty("userName")
	@Column(name = "userName")
    private String userName;
	
	public User(){
	}
	
	public User(String userName){
		this.userName = userName;
	}
    
}
