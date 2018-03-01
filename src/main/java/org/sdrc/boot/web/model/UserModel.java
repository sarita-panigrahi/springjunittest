package org.sdrc.boot.web.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserModel {

	private Long userID;

	private long contactNumber;

	private String createdBY;

	private Timestamp createdDate;

	private String emailID;

	private boolean isAdmin;

	private boolean isLive;

	private String password;

	private String securityA;

	private String sequrityQ;

	private String updatedBy;

	private Timestamp updatedDate;

	private String userFirstName;

	private String userLastName;

	private String userMiddleName;

	@NotNull
	@Length(max=10)
	private String userName;


	public UserModel() {
		super();
	}


	public Long getUserID() {
		return userID;
	}


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getCreatedBY() {
		return createdBY;
	}


	public void setCreatedBY(String createdBY) {
		this.createdBY = createdBY;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public boolean isLive() {
		return isLive;
	}


	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSecurityA() {
		return securityA;
	}


	public void setSecurityA(String securityA) {
		this.securityA = securityA;
	}


	public String getSequrityQ() {
		return sequrityQ;
	}


	public void setSequrityQ(String sequrityQ) {
		this.sequrityQ = sequrityQ;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Timestamp getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserMiddleName() {
		return userMiddleName;
	}


	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


}
