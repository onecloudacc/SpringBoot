package com.learn.springBoot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.cfg.context.Cascadable;

@Entity
public class Account {

	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private boolean enabled= true;
	
	@NotNull
	private boolean credentialsexpired=false;
	
	@NotNull
	private boolean expired=false;
	
	@NotNull
	private boolean locked= false;
	
	@ManyToMany(fetch =FetchType.EAGER,
			    cascade=CascadeType.ALL)
	@JoinTable(name="account_role", joinColumns=@JoinColumn(name="account_Id",referencedColumnName="id")
	  ,inverseJoinColumns=@JoinColumn(name="role_Id",referencedColumnName="id"))
	private Set<Role>roles;
	
	
	

	public Account() {
	
	}




	public Account(Long id, String username, String password, boolean enabled, boolean credentialsexpired,
			boolean expired, boolean locked) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.credentialsexpired = credentialsexpired;
		this.expired = expired;
		this.locked = locked;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
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




	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public boolean isCredentialsexpired() {
		return credentialsexpired;
	}




	public void setCredentialsexpired(boolean credentialsexpired) {
		this.credentialsexpired = credentialsexpired;
	}




	public boolean isExpired() {
		return expired;
	}




	public void setExpired(boolean expired) {
		this.expired = expired;
	}




	public boolean isLocked() {
		return locked;
	}




	public void setLocked(boolean locked) {
		this.locked = locked;
	}



   
	public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}