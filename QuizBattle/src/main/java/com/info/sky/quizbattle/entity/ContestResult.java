package com.info.sky.quizbattle.entity;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Contest_Result")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ContestResult 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "contestId")
	private String contestId;
	
	@JsonIgnore
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
    private Date createdAt;
	
	@Column(name = "winner_object")
	private ArrayList<WinnerEntity> winner;
	
	/*@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss a") */
	@JsonIgnore
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt; 
    	
	@Schema(hidden = true)
	@Column(name = "uqid")
	private String uqid;
}
