package com.info.sky.quizbattle.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Table(name = "user_table")
public class UserEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "email",unique = true)
	private String email;
	
	@JsonIgnore
	@Column(name = "password",unique = true)
	private String password;
	
	@Column(name = "phone",unique = true)
	private String phone;
	
	@JsonIgnore
	@Column(name = "otp")
	private String otp;
	
	@JsonIgnore
	@Column(name = "isactive")
	private boolean isactive;
	
	@JsonIgnore
	@Column(name = "isLogin")
	private boolean isLogin;
	
	@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

	@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt;
      
	@Column(name = "uqid")
	private String uqid;
	
	@Column(name = "token")
	private String token;

	@Column(name = "winning_amt")
	private int winning_amt;
	
	@Column(name = "deposit_amt")
	private int deposit_amt;
	
	@Column(name = "cash_amt")
	private int cash_amt;
	
	@Column(name = "referCode")
	private String referCode;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private UserEntity referBy;
	
}
