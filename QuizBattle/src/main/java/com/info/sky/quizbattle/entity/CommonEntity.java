package com.info.sky.quizbattle.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class CommonEntity implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
    private Date createdAt;

	@JsonIgnore
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt; 
    
	@JsonIgnore
	@Column(name = "isdelete")
	private String isdelete;
	
	@Column(name = "isactive")
	private String isactive;
	
	@Column(name = "uqid")
	private String uqid;
	
	@JsonIgnore
	@Column(name = "ad_by_id")
	private String adByID;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private AdminEntity add_by_model;

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

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
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

	public String getAdByID() {
		return adByID;
	}

	public void setAdByID(String adByID) {
		this.adByID = adByID;
	}

	public AdminEntity getAdd_by_model() {
		return add_by_model;
	}

	public void setAdd_by_model(AdminEntity add_by_model) {
		this.add_by_model = add_by_model;
	}
	
	
	
}
