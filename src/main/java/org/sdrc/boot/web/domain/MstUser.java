package org.sdrc.boot.web.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


/**
 * The persistent class for the MSTUser database table.
 * 
 */
@Entity
public class MstUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userID;

	@NotNull
	@Length(max=10)
	private String userName;
	
	private String userFirstName;
	
	private String password;

	public MstUser() {
		super();
	}

	public MstUser(String userName) {
		super();
		this.userName = userName;
	}

	public MstUser(Long userID) {
		super();
		this.userID = userID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}