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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_details")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "amount")
	private String amount;
		
	@Column(name = "receipt")
	private String receipt;

	@Column(name = "paymetId")
	private String paymetId;
	
	@Column(name = "status")
	private String status;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private UserEntity user_model;
	
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "uqid")
	private String uqid;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
    private Date createdAt;

	@JsonIgnore
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt; 
}
