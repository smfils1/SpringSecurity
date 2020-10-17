package com.spring.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String roles;
	
	private String permissions;

	private int enable;
	

	protected User() {}
	
	public User(String username, String password, String roles, String permissions) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
		this.enable = 1;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public List<String> getRoleList(){
		if(roles.length() > 0) {
			return Arrays.asList(roles.split(","));
		}
		return new ArrayList<>();
	}
	
	public List<String> getPermissionList(){
		if(permissions.length() > 0) {
			return Arrays.asList(permissions.split(","));
		}
		return new ArrayList<>();
	}
}
