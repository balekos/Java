package BootCampProject;

import java.sql.Statement;

public class SimpleUser {
	protected enum Roles {
		USER,ADVISOR,ADMIN;
	}
	private String userName, password, name;
	private int id;
	protected Roles yourRole;

	//public SimpleUser(Roles yourRole) {
		//this.yourRole=yourRole;
	//}

	public SimpleUser(String username,String password,String name) {
		this.userName=username;
		this.password=password;
		this.name=name;
		this.yourRole= Roles.USER;
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
	public int getUserId() {
		return id;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
