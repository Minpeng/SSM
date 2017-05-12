package com.ssm.entity;

/**
 * 关于shrio 用户实体类
 * 
 * @author pengm
 *
 */
public class ShiroUserEntity {
	private int id;

	private String userName;

	private String password;

	private int roleId;

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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId( int roleId ) {
		this.roleId = roleId;
	}
}
