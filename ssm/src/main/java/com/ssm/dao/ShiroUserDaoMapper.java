package com.ssm.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.entity.ShiroUserEntity;

@Repository
public interface ShiroUserDaoMapper {
	ShiroUserEntity findUserByUserName( @Param( "userName" ) String userName );

	Set<String> findRoles( @Param( "userName" ) String userName );

	Set<String> findPermissions( @Param( "userName" ) String userName );
}
