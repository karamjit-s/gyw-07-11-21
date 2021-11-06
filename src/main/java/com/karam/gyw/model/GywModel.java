package com.karam.gyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rules")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GywModel {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "priority")
	private String priority;
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
