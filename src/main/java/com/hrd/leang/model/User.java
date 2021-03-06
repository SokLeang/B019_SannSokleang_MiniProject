package com.hrd.leang.model;

public class User {

	private int id;
	private String name;
	private String gender;
	private String email;
	private int phone_number;
	private String user_hash;
	
	public User(){
		super();
	}
	
	
	public User(int id, String name, String gender, String email, int phone_number, String user_hash) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
		this.user_hash = user_hash;
	}


	public String getUser_hash() {
		return user_hash;
	}
	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	
	
}
