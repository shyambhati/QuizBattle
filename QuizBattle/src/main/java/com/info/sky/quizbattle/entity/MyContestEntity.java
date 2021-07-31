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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "my_contest")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MyContestEntity {

	@Schema(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Schema(description = "Enter contest Unique Id {uqid}")
	@Column(name = "contestId")
	private String contestId;
	

	@ManyToOne(cascade = CascadeType.MERGE)
	private ContestEntity contestEntity;
	
	@Schema(description = "Enter User Unique Id {uqid}")
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "status")
	private String status;
	
	@Schema(hidden = true)
	@JsonIgnore
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
    private Date createdAt;
	
	@Schema(hidden = true)
	@JsonIgnore
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt; 
    	
	@Schema(hidden = true)
	@Column(name = "uqid")
	private String uqid;
	
	
}
