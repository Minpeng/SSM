package com.ssm.shiro;

import java.io.Serializable;

import com.google.common.base.Objects;

public class SerShiroUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String userName;

	private String password;

	private String permission;

	private String roleName;

	private String coding;

	public String getCoding() {
		return coding;
	}

	public void setCoding( String coding ) {
		this.coding = coding;
	}

	public SerShiroUser(int id, String coding, String userName, String password, String permission, String roleName) {
		this.id = id;
		this.coding = coding;
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

	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		return coding;
	}

	/**
	 * 重载hashCode,只计算coding;
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode( coding );
	}

	/**
	 * 重载equals,只计算coding;
	 */
	@Override
	public boolean equals( Object obj ) {
		if( this == obj ) {
			return true;
		}
		if( obj == null ) {
			return false;
		}
		if( getClass() != obj.getClass() ) {
			return false;
		}
		SerShiroUser other = (SerShiroUser)obj;
		if( coding == null ) {
			if( other.coding != null ) {
				return false;
			}
		}
		else if( !coding.equals( other.coding ) ) {
			return false;
		}
		return true;
	}
}
