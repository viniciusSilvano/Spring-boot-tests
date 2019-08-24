package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.StatusRoleEnum;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private StatusRoleEnum status;
	
	//Não é bom usar eager em aplicações reais, pois traz todos os dados
	// relacionados. É melhor usar o repository para fazer isso
	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Functionality> functionalities;
	
	
	public Role() {
		super();
	}

	public Role(String name, StatusRoleEnum status, List<Functionality> functionalities) {
		super();
		this.name = name;
		this.status = status;
		this.functionalities = functionalities;
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

	public List<Functionality> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(List<Functionality> functionalities) {
		this.functionalities = functionalities;
	}
		
	
}
