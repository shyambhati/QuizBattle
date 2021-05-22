package com.info.sky.quizbattle.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.xml.ws.soap.Addressing;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public  class CommonEntity implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss a")
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
    private Date createdAt;

	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss a")
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt; 
    	
	@Column(name = "isdelete")
	private String isdelete;
	
	@Column(name = "isactive")
	private String isactive;
	
	@Column(name = "uqid")
	private String uqid;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private AdminEntity add_by_model;

}
