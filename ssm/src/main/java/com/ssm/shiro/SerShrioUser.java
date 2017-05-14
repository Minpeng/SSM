package com.ssm.shiro;

import java.io.Serializable;

public class SerShrioUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String userName;

	private String password;

	private String permission;

	private String roleName;

	public SerShrioUser(int id, String userName, String password, String permission, String roleName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.permission = permission;
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName( String userName ) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission( String permission ) {
		this.permission = permission;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName( String roleName ) {
		this.roleName = roleName;
	}

}
