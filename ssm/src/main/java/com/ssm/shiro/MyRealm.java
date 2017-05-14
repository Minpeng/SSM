package com.ssm.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.dao.ShiroUserDaoMapper;
import com.ssm.entity.ShiroUserEntity;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	ShiroUserDaoMapper shiroUserDaoMapper;
	/*
	 * (non-Javadoc) 用户权限的认证
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principals ) {
		//test
		SerShiroUser serShiroUser = (SerShiroUser)principals.getPrimaryPrincipal();
		System.out.println( "...username...." + serShiroUser.getUserName() );
		//获取用户名
		String userName = principals.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roleName = shiroUserDaoMapper.findRoles( userName );
		Set<String> permissions = shiroUserDaoMapper.findPermissions( userName );
		
		info.setRoles( roleName );
		info.setStringPermissions( permissions );
		return info;
	}
	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken token ) {
		 //获取用户账号
        String userName = token.getPrincipal().toString() ;
		ShiroUserEntity shiroUser = shiroUserDaoMapper.findUserByUserName( userName );
		if( shiroUser == null ) {
			return null;
		}
		// 将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realmName。
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo( shiroUser.getUserName(), shiroUser.getPassword(),
		        getName() );
		return authenticationInfo;

    }

}


