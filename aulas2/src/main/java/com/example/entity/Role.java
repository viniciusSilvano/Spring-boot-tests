package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.StatusRoleEnum;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private StatusRoleEnum status;
	
	
	
	public Role() {
		super();
	}

	public Role(String name, StatusRoleEnum status) {
		super();
		this.name = name;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusRoleEnum getStatus() {
		return status;
	}

	public void setStatus(StatusRoleEnum status) {
		this.status = status;
	}
		
}
