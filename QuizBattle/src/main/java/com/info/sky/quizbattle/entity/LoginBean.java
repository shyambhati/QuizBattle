package com.info.sky.quizbattle.entity;

public class LoginBean 
{
	private String username="";
	private String password="";
	private String otp;
	private String role;
	private String remberMe;
	private String captcha;
	
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
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRemberMe() {
		return remberMe;
	}
	public void setRemberMe(String remberMe) {
		this.remberMe = remberMe;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
}
