/**
 * 
 */
package com.hugo.api.persistence.bean;

/**
 * @author Hugo
 *
 */
public class MongoUser {
	
	
	private String userName;
	private String hashPassword;
	private String mail;
	
	public MongoUser(){
		
	}	
	public MongoUser(String userName , String hashPassword , String mail){
		this.userName = userName;
		this.hashPassword = hashPassword;
		this.mail = mail;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHashPassword() {
		return hashPassword;
	}
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
