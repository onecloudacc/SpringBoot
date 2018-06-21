
package com.learn.springBoot.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author rmahad
 *
 */
@Entity
public class MyUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
    private String userName;
	private String password;
	private String emailId;
	private int enabled;
	

	
	
	
	
	public MyUser() {
	
	}
	public MyUser(Long userId, String userName, String password, String emailId, int enabled) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.enabled = enabled;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	
}