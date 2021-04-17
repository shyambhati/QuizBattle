package com.info.sky.quizbattle.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class AdminEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "otp")
	private String otp;
	
	@Column(name = "lastlogin")
	private String lastlogin;
	
	@Column(name = "totallogin")
	private String totallogin;
	
	@Column(name = "isdeveloper")
	private String isdeveloper;
	

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

	@Column(name = "isactive")
	private String isactive;
	
	@Column(name = "uqid")
	private String uqid;
	
	@Column(name = "login_role")
	private String role;

	@Column(name = "token")
	private String token;

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEntity(int id, String name, String phone, String email, String username, String password, String otp,
			String lastlogin, String totallogin, String isdeveloper, Date createdAt, Date updatedAt, String isactive,
			String uqid, String role, String token) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.otp = otp;
		this.lastlogin = lastlogin;
		this.totallogin = totallogin;
		this.isdeveloper = isdeveloper;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isactive = isactive;
		this.uqid = uqid;
		this.role = role;
		this.token = token;
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

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getTotallogin() {
		return totallogin;
	}

	public void setTotallogin(String totallogin) {
		this.totallogin = totallogin;
	}

	public String getIsdeveloper() {
		return isdeveloper;
	}

	public void setIsdeveloper(String isdeveloper) {
		this.isdeveloper = isdeveloper;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getUqid() {
		return uqid;
	}

	public void setUqid(String uqid) {
		this.uqid = uqid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
