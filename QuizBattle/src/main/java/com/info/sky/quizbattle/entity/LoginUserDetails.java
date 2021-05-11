package com.info.sky.quizbattle.entity;

import org.springframework.stereotype.Component;

@Component
public class LoginUserDetails {	
	private int  id;	
	private String name;	
	private String phone;	
	private String email;		
	private String status;	
	private String uqId;	
	private String username;	
	private String password;	
	private String role;
	private boolean flag=false;
	
	public LoginUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUserDetails(int id, String name, String phone, String email,
			String status, String uqId, String username, String password,
			String role, boolean flag) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.uqId = uqId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.flag = flag;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUqId() {
		return uqId;
	}

	public void setUqId(String uqId) {
		this.uqId = uqId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
}
